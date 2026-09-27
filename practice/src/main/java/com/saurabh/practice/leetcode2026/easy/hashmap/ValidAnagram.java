package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.Arrays;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] charArrayOne = new int[26];
        for(char c : s.toCharArray()){
            charArrayOne[c - 'a']++;
        }

        int[] charArrayTwo = new int[26];
        for(char c : t.toCharArray()){
            charArrayTwo[c - 'a']++;
        }
        String val1 = Arrays.toString(charArrayOne);
        String val2 = Arrays.toString(charArrayTwo);

        System.out.println(val1);
        System.out.println(val2);

        if(val1.equals(val2))
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }
}
