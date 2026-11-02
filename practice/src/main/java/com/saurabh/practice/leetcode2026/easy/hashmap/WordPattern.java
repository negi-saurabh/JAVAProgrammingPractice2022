package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern {

    public boolean wordPattern(String pattern, String s) {

        String[] words = s.trim().split("\\s+");

        if (words.length != pattern.length())
            return false;

        Map<Character, String> map = new HashMap<>();
        Set<String> usedWords = new HashSet<>();

        for (int i = 0; i < pattern.length(); i++) {

            char c = pattern.charAt(i);
            String word = words[i];

            if (map.containsKey(c)) {
                if (!map.get(c).equals(word))
                    return false;
            } else {
                if (usedWords.contains(word))
                    return false;

                map.put(c, word);
                usedWords.add(word);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println( new WordPattern().wordPattern("abba", "dog cat cat fish"));
    }
}
