package com.saurabh.practice.leetcode2026.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
