package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // First pass: calculate prefix products
        int prefix = 1;

        for (int i = 0; i < n; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        // Second pass: multiply by suffix products
        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4});
    }
}
