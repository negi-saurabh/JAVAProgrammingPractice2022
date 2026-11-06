package com.saurabh.practice.leetcode2026.medium.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        // loop over string
        // create a set to to store all characters
        // add from the right if its a duplicate save the length and remove from left till you remove
        // current character

        Set<Character> charSet = new HashSet<>();
        int longestSub = 0;

        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(c);

            while (charSet.contains(c)) {
                char removed = builder.charAt(0);
                charSet.remove(removed);
                builder.deleteCharAt(0);
            }
            charSet.add(c);

            longestSub = Math.max(longestSub, builder.length());
        }

        return longestSub;
    }

    public static void main(String[] args) {
        new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("baaabca");
    }
}
