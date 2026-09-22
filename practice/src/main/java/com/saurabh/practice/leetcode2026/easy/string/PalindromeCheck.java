package com.saurabh.practice.leetcode2026.easy.string;

import com.saurabh.practice.leetcode2026.easy.array.MergeSortedArray;

public class PalindromeCheck {

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0;
        int last = s.length() - 1;
        while(start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);
            if (!Character.isLetterOrDigit(currFirst )) {
                start++;
            } else if(!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {

//            System.out.println("      ".length());
       System.out.println(new PalindromeCheck().isPalindrome("0P"));
    }

}
