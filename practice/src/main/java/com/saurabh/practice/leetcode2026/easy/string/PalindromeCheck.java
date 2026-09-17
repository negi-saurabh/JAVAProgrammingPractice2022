package com.saurabh.practice.leetcode2026.easy.string;

import com.saurabh.practice.leetcode2026.easy.array.MergeSortedArray;

public class PalindromeCheck {

        public boolean isPalindrome(String s) {

            if(s.trim() == "")
                return true;

            StringBuffer buffer = new StringBuffer();

            for(int i = 0; i < s.length() ; i++){
                if(Character.isAlphabetic(s.charAt(i))){
                    buffer.append(s.charAt(i));
                }
            }

            String cleanString  = buffer.toString().toLowerCase();

            int j = cleanString.length()-1;
            int mid = j/2;

            for(int i = 0; i <= mid ; i++){
                if(cleanString.charAt(i) != cleanString.charAt(j)){
                    return false;
                }
                j--;
            }
            return true;
        }

    public static void main(String[] args) {
       System.out.println(new PalindromeCheck().isPalindrome("race a car"));
    }

}
