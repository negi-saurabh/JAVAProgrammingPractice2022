package com.saurabh.practice.leetcode2026.medium.heap;


import java.util.PriorityQueue;

public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue();

        for(int i : nums){
            minHeap.offer(i);

            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        return  minHeap.peek();
    }

}
