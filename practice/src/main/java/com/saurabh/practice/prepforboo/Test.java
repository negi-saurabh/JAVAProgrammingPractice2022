package com.saurabh.practice.prepforboo;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
    public int shortestSubarray(int[] nums, int target) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>(); // stores indices into prefix[]
        int minLen = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= target) {
                minLen = Math.min(minLen, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }

    public static void main(String[] args) {
        Test sol = new Test();

        int[] nums1 = {2, -1, 2};
        System.out.println("nums = [2, -1, 2], target = 3 -> " + sol.shortestSubarray(nums1, 3));

        int[] nums2 = {1};
        System.out.println("nums = [1], target = 1 -> " + sol.shortestSubarray(nums2, 1));

        int[] nums3 = {1, 2};
        System.out.println("nums = [1, 2], target = 4 -> " + sol.shortestSubarray(nums3, 4));

        int[] nums4 = {3, -1, 4};
        System.out.println("nums = [3, -1, 4], target = 6 -> " + sol.shortestSubarray(nums4, 6));

        int[] nums5 = {84, -37, 32, 40, 95};
        System.out.println("nums = [84, -37, 32, 40, 95], target = 167 -> " + sol.shortestSubarray(nums5, 167));
    }
}
