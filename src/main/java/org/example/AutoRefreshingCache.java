package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AutoRefreshingCache<K, V> {
    private final Map<K, CacheEntry<V>> cache = new HashMap<>();
    private final ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();

    public void put(K key, V value, long timeToLive, TimeUnit timeUnit) {
        CacheEntry<V> entry = new CacheEntry<>(value, System.currentTimeMillis() + timeUnit.toMillis(timeToLive));
        cache.put(key, entry);
    }

    public V get(K key) {
        CacheEntry<V> entry = cache.get(key);
        if (entry != null && entry.isValid()) {
            return entry.getValue();
        } else {
            // Perform cache miss handling, such as fetching data from the source
            // and putting it into the cache
            // ...

            // For demonstration purposes, let's assume fetchDataFromSource() is a method
            // that fetches data from the source
            V freshData = fetchDataFromSource();
            put(key, freshData, 5, TimeUnit.MINUTES); // Cache the fresh data for 5 minutes
            return freshData;
        }
    }

    private V fetchDataFromSource() {
        // Logic to fetch data from the source
        // ...
        return null;
    }

    private static class CacheEntry<V> {
        private final V value;
        private final long expirationTime;

        public CacheEntry(V value, long expirationTime) {
            this.value = value;
            this.expirationTime = expirationTime;
        }

        public V getValue() {
            return value;
        }

        public boolean isValid() {
            return System.currentTimeMillis() < expirationTime;
        }
    }

    public AutoRefreshingCache() {
        // Schedule a periodic task to clean up expired entries
        scheduler.scheduleAtFixedRate(this::cleanupExpiredEntries, 0, 1, TimeUnit.MINUTES);
    }

    private void cleanupExpiredEntries() {
        // Remove entries that have expired
        cache.entrySet().removeIf(entry -> !entry.getValue().isValid());
    }
}
