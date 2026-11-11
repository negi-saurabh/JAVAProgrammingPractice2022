package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class RemoveIndexFromSortedArray2 {
    public int removeDuplicates(int[] nums) {

        // iterate through the array
        // start with index 1 and check with 0 in first iteration
        // if adjacent elements are equal and count is more than 2
        // skip else save it
        // need one index for the new array

        int index = 0;
        int n=nums.length;
        for(int i = 0; i < n ; i++){
            if(index < 2 || nums[i] != nums[index-2]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        new RemoveIndexFromSortedArray2().removeDuplicates(new int[]{
                0,0,1,1,1,1,2,3,3
        });
    }
}
