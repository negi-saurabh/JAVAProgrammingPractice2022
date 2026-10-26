package com.saurabh.practice.leetcode2026.medium.stringANDarray;

import java.util.Arrays;
import java.util.Collections;

public class HIndexUsingSort {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        int[] arrDesc = Arrays.stream(citations).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        for(int i = 0; i < arrDesc.length; i++){
            if(arrDesc[i] > hIndex)
                hIndex++;
            else{
                break;
            }
        }
        return hIndex;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexUsingSort().hIndex(new int[]{3,0,6,1,5}));
    }
}
