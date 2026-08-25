package com.saurabh.practice.datastructures;

import java.util.*;

public class HashMapUsage {

//    Operation	                        HashMap
//   ===========                        =======
//   get, put , remove                     O(1)

//    When to use:
//    the single most common interview tool. Frequency counting, deduplication, "have I seen this before",
//    grouping, caching, two-sum style lookups, index-of-value mapping.

//    When to avoid:
//    you need order (insertion or sorted) — plain HashMap gives no guarantees.

//    Interview tell:
//    if a problem needs "find/check/count something fast", reach for HashMap first and ask yourself only afterward if you need ordering.
    public static void main(String[] args) {
        // 1) HashMap - Key value pair, backed by hash table
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.get("a");
        map.getOrDefault("b", 0);
        map.merge("b", 1, Integer::sum);

        Map<String, List<String>> map2 = new HashMap<>();
        map2.computeIfAbsent("a", k -> new ArrayList<>()).add("sa");

        // 1) LinkedHashMap - HashMap + predictable iteration order (insertion order, or access order if configured). This is Java's building block for an LRU cache.
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
    }
}
