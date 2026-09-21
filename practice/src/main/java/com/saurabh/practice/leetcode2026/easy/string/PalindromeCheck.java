package com.saurabh.practice.leetcode2026.easy.string;

import com.saurabh.practice.leetcode2026.easy.array.MergeSortedArray;

public class PalindromeCheck {

        public boolean isPalindrome(String s) {
            StringBuilder builder = new StringBuilder();

            for(int i = 0; i < s.length() ; i++){
                if(Character.isLetterOrDigit(s.charAt(i))){
                    builder.append(s.charAt(i));
                }
            }

            String cleanString  = builder.toString().toLowerCase();
            if(cleanString.length() == 0)
                return true;

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

//            System.out.println("      ".length());
       System.out.println(new PalindromeCheck().isPalindrome("0P"));
    }

}
