package com.saurabh.practice.leetcode2026.medium.KadaneAlgorithm;

public class MaximumSubArray {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        new MaximumSubArray().maxSubArray(new int[]{-1, -2});
    }
}
