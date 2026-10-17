package com.saurabh.practice.leetcode2026.easy.stringANDarray;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {

        String trimmed = s.trim();
        String[] stringArray = trimmed.split("\\s+");

        return stringArray[stringArray.length-1].length();
    }

    public static void main(String[] args) {
       System.out.println(new LengthOfLastWord().lengthOfLastWord("vbv   asdasdasd    asdasdasd   dsfsdfdsbb"));
    }
}
