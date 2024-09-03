package org.example.generics;

import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {

    //Hashmap
    final HashMap<Integer,String> cache;
    final LinkedList<String> lruSequence;
    final int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        lruSequence = new LinkedList<>();
    }
    public void putElement(Integer key, String value) { //
        if(cache.size() < capacity) {
            cache.put(key, value);
            lruSequence.addFirst(String.valueOf(key));
        } else {
            Integer leastUsedElement = Integer.valueOf(lruSequence.removeLast());
            String leastUsedValue = cache.remove(leastUsedElement);
            System.out.println("leastUsedValue = " + leastUsedValue);
            cache.put(key, value);
            lruSequence.addFirst(String.valueOf(key));
        }

    }

    public String getElement(Integer key) {
        String keyVal = String.valueOf(key);
        String value = cache.get(key);
        lruSequence.remove(keyVal);
        lruSequence.addFirst(keyVal);
        return value;
    }

    //
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.putElement(1,"AB");
        cache.putElement(2,"LM");
        cache.putElement(3,"XY");
        cache.putElement(4,"ZY");
        System.out.println("value = " + cache.getElement(3));
        System.out.println("value = " + cache.getElement(2));
        cache.putElement(5,"LH");
        System.out.println("value = " + cache.getElement(5));
    }


}
