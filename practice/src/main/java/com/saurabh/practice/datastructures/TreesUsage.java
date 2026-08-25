package com.saurabh.practice.datastructures;

import java.util.HashSet;
import java.util.Set;

public class TreesUsage {

//    Operation
//   ===========                        =======
//

//    When to use:
//    hierarchical data, and BSTs specifically for ordered search — but in practice TreeMap/TreeSet already give you this without hand-rolling a tree.

//    When to avoid:
//

//    Interview tell:
//
    public static void main(String[] args) {
        // 1) Trees - hierarchical, each node with children. BST keeps left < node < right.
        Set<Integer> seen = new HashSet<>();
        seen.add(1);
        seen.contains(1);

    }
}
