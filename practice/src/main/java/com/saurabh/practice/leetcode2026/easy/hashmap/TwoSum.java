package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int[] returnArray = new int[2];
        Map<Integer, Integer> differenceMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(differenceMap.containsKey(target - nums[i])){
                returnArray[0] = differenceMap.get(target - nums[i]);
                returnArray[1] = i;
            }
            differenceMap.put(nums[i], i);
        }

        return returnArray;
    }

    public static void main(String[] args) {
        new TwoSum().twoSum(new int[]{3,3}, 6);
    }
}
