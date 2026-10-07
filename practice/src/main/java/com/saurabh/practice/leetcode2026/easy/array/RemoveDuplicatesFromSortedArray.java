package com.saurabh.practice.leetcode2026.easy.array;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                index++;
            }
        }

        return index;
    }
}
