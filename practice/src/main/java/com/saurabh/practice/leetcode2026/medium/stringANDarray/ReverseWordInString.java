package com.saurabh.practice.leetcode2026.medium.stringANDarray;

import java.util.Arrays;

public class ReverseWordInString {
    public String reverseWords(String s) {

        // need to use two pointers
        // start from both ends
        // check if start and end are space remove unless you reach the word
        // once started, any consecutive spaces must be removed
        String[] strArray = s.trim().split("\\s+");
        int left=0, right = strArray.length-1;

        while (left < right) {
            String temp = strArray[left];
            strArray[left] = strArray[right];
            strArray[right] = temp;

            left++;
            right--;
        }

        return Arrays.stream(strArray)
                .reduce((a, b) -> a + " " + b)
                .orElse("");
    }

    public static void main(String[] args) {
        new ReverseWordInString().reverseWords("");
    }
}
