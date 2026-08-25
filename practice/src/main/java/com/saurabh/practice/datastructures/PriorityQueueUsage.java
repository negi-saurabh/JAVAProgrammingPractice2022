package com.saurabh.practice.datastructures;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class PriorityQueueUsage {

//    Operation	                            PriorityQueue
//   ===========                            =======
//   offer/poll                              O(log n)
//   peek                                       1

//    When to use:
//    Top-K problems, "K most frequent", "K closest reservations", merge K sorted lists, scheduling by priority/deadline.
//    Very common in the "business scenario" style Booking uses.

//    When to avoid:
//    When order is not needed

//    Interview tell:
//
    public static void main(String[] args) {
        // 1) PriorityQueue , binary heap — always gives you the min (or max, with a comparator) in O(log n).
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap.offer(5);
        minHeap.poll(); // smallest
    }
}
