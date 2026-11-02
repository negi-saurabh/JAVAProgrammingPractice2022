package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] stringArray = s.split("\\s+");
        char[] charArray = pattern.toCharArray();

        if(stringArray.length != charArray.length)
            return false;

        Map<Character, String> map = new HashMap<>();

        for(int i=0; i < charArray.length; i++){
            if(map.containsValue(stringArray[i]) && !map.containsKey(charArray[i]))
                return false;
            if(map.containsKey(charArray[i]) && !map.get(charArray[i]).equals(stringArray[i]))
                return false;
            map.put(charArray[i], stringArray[i]);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println( new WordPattern().wordPattern("abba", "dog cat cat fish"));
    }
}
