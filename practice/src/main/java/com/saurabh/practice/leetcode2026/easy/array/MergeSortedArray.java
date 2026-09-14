package com.saurabh.practice.leetcode2026.easy.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0){
            for(int i = 0 ; i < n; i++){
                nums1[i] = nums2[i];
            }
            return;
        }
        if(n == 0){
            return;
        }
        int  j=0;
        for(int i = 0 ; i < m ;){
            if(nums2[j] < nums1[i]){
                int temp = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = temp;
                j++;
            } else{
                i++;
            }
        }

        for(int i = 0 ; i < n; i++){
            nums1[i+m] = nums2[i];
        }
        Arrays.stream(nums1).forEach(System.out::println);
    }

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{2,0}, 1, new int[]{1}, 1);
    }
}
