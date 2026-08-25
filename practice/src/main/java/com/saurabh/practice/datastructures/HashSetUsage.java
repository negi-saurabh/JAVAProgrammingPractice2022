package com.saurabh.practice.datastructures;

import java.util.*;

public class HashSetUsage {

//    Operation	                        HashSet
//   ===========                        =======
//   add, contains                       O(1)

//    When to use:
//    deduplication, membership tests, "any duplicates in this array."

//    When to avoid:
//

//    Interview tell:
//
    public static void main(String[] args) {
        // 1) HashSet - HashMap with no values — just "have I seen this key."
        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        seen.contains(1);

    }
}
