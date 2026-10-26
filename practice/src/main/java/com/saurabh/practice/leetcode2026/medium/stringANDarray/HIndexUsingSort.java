package com.saurabh.practice.leetcode2026.medium.stringANDarray;

import java.util.Arrays;
import java.util.Collections;

public class HIndexUsingSort {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++){
            int papers=n-i;
            if(citations[i]>=papers){
                return papers;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexUsingSort().hIndex(new int[]{3,0,6,1,5}));
    }
}
