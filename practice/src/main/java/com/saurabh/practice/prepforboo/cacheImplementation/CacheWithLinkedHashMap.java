package com.saurabh.practice.prepforboo.cacheImplementation;

import java.util.LinkedHashMap;
import java.util.Map;

public class CacheWithLinkedHashMap<K, V> {
    private final int capacity;
    private final Map<K, V> cache;

    public CacheWithLinkedHashMap(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size()>capacity;
            }
        };
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public static void main(String[] args) {
        CacheWithLinkedHashMap<String, Integer> integerIntegerCacheWithLinkedHashMap = new CacheWithLinkedHashMap<>(2);
        integerIntegerCacheWithLinkedHashMap.put("A", 1);
        integerIntegerCacheWithLinkedHashMap.put("B", 1);
        integerIntegerCacheWithLinkedHashMap.put("C", 1);
        integerIntegerCacheWithLinkedHashMap.put("D", 1);
        integerIntegerCacheWithLinkedHashMap.put("C", 99);
        integerIntegerCacheWithLinkedHashMap.put("E", 99);

        integerIntegerCacheWithLinkedHashMap.cache.keySet().forEach(k -> System.out.println(k));

        System.out.println(integerIntegerCacheWithLinkedHashMap.get("A"));
        System.out.println(integerIntegerCacheWithLinkedHashMap.get("B"));
        System.out.println(integerIntegerCacheWithLinkedHashMap.get("C"));
        System.out.println(integerIntegerCacheWithLinkedHashMap.get("D"));
        System.out.println(integerIntegerCacheWithLinkedHashMap.get("E"));
    }

}
