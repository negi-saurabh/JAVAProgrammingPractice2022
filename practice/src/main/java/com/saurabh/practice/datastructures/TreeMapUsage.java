package com.saurabh.practice.datastructures;

import java.util.*;

public class TreeMapUsage {

//    Operation	                            TreeMap
//   ===========                            =======
//   get, put , remove, containsKey         O(log n)

//    When to use:
//    you need sorted order maintained dynamically, range queries, "closest value" lookups,
//    or intervals (e.g. merge intervals, find the reservation just before/after a given time).

//    When to avoid:
//    When order is not needed

//    Interview tell:
//
    public static void main(String[] args) {
        // 1) TreeMap , TreeSet
        // What it is: Red-black tree backed — sorted map/set.
        TreeMap<String, String> tm = new TreeMap<>();
        tm.firstKey();        // smallest key
        tm.lastKey();         // largest key
        tm.higherKey("apple"); // smallest key strictly greater than "apple"
        tm.lowerKey("apple");  // largest key strictly less than "apple"
        tm.ceilingKey("b");    // smallest key >= "b"
        tm.floorKey("b");      // largest key <= "b"
        tm.headMap("banana");  // all entries with key < "banana"
        tm.tailMap("banana");  // all entries with key >= "banana"
        tm.subMap("apple", "cherry"); // range view
    }
}
