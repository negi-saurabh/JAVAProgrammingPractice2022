package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> charMap = new HashMap<>();
        for(int i = 0; i< magazine.length();i++){
            charMap.merge(magazine.charAt(i), 1, Integer::sum);
        }


        for(int i = 0; i< ransomNote.length();i++){
            if(charMap.containsKey(ransomNote.charAt(i))){
                Integer val = charMap.get(ransomNote.charAt(i));
                val -= 1;
                if(val==0){
                    charMap.remove(ransomNote.charAt(i));
                }else {
                    charMap.put(ransomNote.charAt(i), val);
                }
            }else{
                return false ;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new RansomNote().canConstruct("aa", "ab");
    }
}
