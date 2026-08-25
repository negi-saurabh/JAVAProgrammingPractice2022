package com.saurabh.practice.prepforboo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DayTwo {

    public static void main(String[] args) {

        System.out.println(isPalindrome("NAMAN"));
        minSubArrayLengthWithAllowedPositiveArray( 4, new int[]{2,3,1,2,4,3});
    }

    public static boolean isPalindrome(String s) {
        // your code
        char[] charArray =s.toLowerCase().toCharArray();
        StringBuffer  buffer = new StringBuffer();
        for(int i = 0; i < charArray.length;i++ ) {
                if(Character.isLetterOrDigit(charArray[i])){
                    buffer.append(charArray[i]);
            }
        }
        String cleanedString = buffer.toString();
        int j= cleanedString.length()-1;
        for(int i = 0; i < j;i++ ){
            if(cleanedString.toCharArray()[i] != cleanedString.toCharArray()[j]){
                return false;
            }
            j--;
        }
        return true;
    }


    public static int lengthOfLongestSubstring(String s) {
        // your code


        int longest = 0;
        int left = 0;
        char[] charArray = s.toCharArray();
        Set<Character> substringSet = new HashSet<>();
        for (int right = 0 ; right < charArray.length; right++){
                char c = charArray[right];
                while (substringSet.contains(c)) {
                    substringSet.remove(charArray[left]);
                    left++;
                }
                substringSet.add(c);
                longest = Math.max(longest, right - left + 1);
        }
        return longest;
    }

    public static int lengthOfLongestSubstringTakeTwo(String s) {
        // your code

       int longest = 0,  left = 0;
       char[] charArray = s.toCharArray();
       Map<Character, Integer> lastSeenIndex = new HashMap<>();
       for (int right =0 ; right < charArray.length;right++){
           char c = charArray[right];
           if (lastSeenIndex.containsKey(c))
                left = Math.max(left, lastSeenIndex.get(c) + 1);
           lastSeenIndex.merge(c, right , (o, n) -> n);
           longest = Math.max(longest, right-left+1);
       }

       return longest;
    }

    public static int minSubArrayLengthWithAllowedPositiveArray(int target, int[] nums) {
       int minLength = Integer.MAX_VALUE , left= 0, sum = 0 ;

       for(int right = 0 ; right < nums.length ;right ++) {
           sum += nums[right];
           while (sum >= target) {
               minLength = Math.min(minLength, right - left + 1);
               sum -= nums[left];
               left++;
           }
       }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    public static int minSubArrayLenNeg(int target, int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n + 1];                  // prefix[k] = sum of first k elements
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + nums[i];

        int minLen = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {                    // end of subarray
            for (int i = j - 1; i >= 0; i--) {            // start, scanning back from closest
                if (prefix[j] - prefix[i] >= target) {    // subarray (i, j] sums to >= target
                    minLen = Math.min(minLen, j - i);
                    break;                                // largest i = shortest for this j → stop
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
