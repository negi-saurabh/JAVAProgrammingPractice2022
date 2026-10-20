package com.saurabh.practice.leetcode2026.easy.stringANDarray;

public class IndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {

        if(needle.length() > haystack.length())
            return -1;

        int left = 0;
        int right;
        int minIndex = Integer.MAX_VALUE;

        for(right = needle.length()-1 ; right < haystack.length() ; right++){
            String sub = haystack.substring(left, right+1);

            if(sub.equals(needle)){
                minIndex = Math.min(minIndex, left);
            }
            left++;
        }

        return minIndex == Integer.MAX_VALUE ? -1 : minIndex;
    }
    public static void main(String[] args) {
         System.out.println(new IndexOfTheFirstOccurrenceInAString().strStr("mississippi","issip"));
    }
}
