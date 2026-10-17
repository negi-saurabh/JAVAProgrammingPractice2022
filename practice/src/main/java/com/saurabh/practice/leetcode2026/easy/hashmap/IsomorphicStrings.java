package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Character> mappingArray = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (mappingArray.containsKey(s.charAt(i)) || mappingArray.containsValue(t.charAt(i)))
                continue;
            mappingArray.put(s.charAt(i), t.charAt(i));
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            builder.append(mappingArray.get(s.charAt(i)));
        }

        if (builder.toString().equals(t))
            return true;
        else
            return false;

    }

    public static void main(String[] args) {
        new IsomorphicStrings().isIsomorphic("badc", "baba");
    }
}
