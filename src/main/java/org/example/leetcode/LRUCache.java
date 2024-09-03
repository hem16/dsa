package org.example.leetcode;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    //Cache storage
    HashMap<Integer,Integer> cacheStorage;
    //Maintaining capacity and sequence
    LinkedList<Integer> ll;
    final int  capacity;

    LRUCache(int capacity) {
        this.capacity = capacity;
        cacheStorage = new HashMap<>();
        ll = new LinkedList<>();
    }

    void put(int key, int value) {
        if (key > capacity) {
            int keyToRemove = ll.removeLast();
            cacheStorage.remove(keyToRemove);
        }
        ll.addFirst(key);
        cacheStorage.put(key, Integer.valueOf(value));
    }

    int get(int key) {
        Integer value = cacheStorage.get(key);
        if(value != null){
            cacheStorage.remove(key);
            ll.removeLast();
            ll.addFirst(key);
        } else {
            value = -1;
        }
        return value;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        cache.get(3);
        cache.put(1,10);
        cache.get(3);
        cache.get(1);


    }
}
