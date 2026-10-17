package com.saurabh.practice.leetcode2026.easy.twopointers;

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i, COUNT=0, j=0;
        char[] arrayOne = s.toCharArray();
        char[] arrayTwo = t.toCharArray();
        int lengthOf = arrayOne.length;

        for(i = 0; i < arrayTwo.length; i++){
            if(lengthOf > 0 && arrayOne[j]==arrayTwo[i]){
                j++;
                lengthOf--;
            }
        }

        if( COUNT == lengthOf)
            return true;
        else
            return false;
    }
}
