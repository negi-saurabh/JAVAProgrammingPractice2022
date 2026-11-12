package com.saurabh.practice.leetcode2026.medium.twopointers;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        // start from both ends
        // start calculating and store in a max number
        // now from both ends which ever is short we need to move that by one index

        int left = 0;
        int right = height.length - 1;
        int maxVolume = Integer.MIN_VALUE;

        while (left < right) {
            int volume = (right - left) * Math.min(height[left], height[right]);
            maxVolume = Math.max(maxVolume, volume);

            if (height[right] < height[left])
                right--;
            else
                left++;

        }
        return maxVolume;
    }

    public static void main(String[] args) {
        new ContainerWithMostWater().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }
}
