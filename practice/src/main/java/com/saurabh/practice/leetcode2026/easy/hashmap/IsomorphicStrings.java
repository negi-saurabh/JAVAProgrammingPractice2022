package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {

        if(s.length() != t.length())
            return false;

        Map<Character, Character> mappingArray = new LinkedHashMap<>();

        for(int i=0; i < s.length();i++){
            mappingArray.put(s.charAt(i), t.charAt(i));
        }

        StringBuilder builder = new StringBuilder();

        for(int i=0; i < s.length();i++){
           builder.append(mappingArray.get(s.charAt(i)));
        }

        if(builder.toString().equals(t))
            return true;
        else
            return false;
    }
}
