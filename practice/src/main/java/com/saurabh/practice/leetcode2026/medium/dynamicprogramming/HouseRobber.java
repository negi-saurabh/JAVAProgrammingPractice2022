package com.saurabh.practice.leetcode2026.medium.dynamicprogramming;

public class HouseRobber {

    public int rob(int[] nums) {

        if(nums.length == 1)
            return nums[0];
        // loop through
        // at given house we need to see if
        // choosing current gives max or choosing previous gives max

        int maxValue = Integer.MIN_VALUE;
        int prevSum = nums[0];
        int prevPrevSum = 0;

        for(int i = 1 ; i < nums.length ; i++){
            maxValue = Math.max(prevPrevSum + nums[i], prevSum);
            prevPrevSum = prevSum;
            prevSum = maxValue;
        }

        return maxValue;
    }
}
