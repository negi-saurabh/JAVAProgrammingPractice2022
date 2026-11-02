package com.saurabh.practice.leetcode2026.easy.stringANDarray;

public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int countVal = 0;
        int count = 0;
        int lastIndex = nums.length - 1;

        for (int i = 0; i <= lastIndex; i++) {

            if (nums[i] == val) {

                while (i < lastIndex && nums[lastIndex] == val) {
                    lastIndex--;
                }

                if (i < lastIndex) {
                    nums[i] = nums[lastIndex];
                    lastIndex--;
                } else {
                    break;
                }
            }
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        new RemoveElement().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
    }
}
