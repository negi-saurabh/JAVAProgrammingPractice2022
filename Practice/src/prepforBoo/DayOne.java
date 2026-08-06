package prepforBoo;

import java.util.*;
import java.util.stream.Collectors;

public class DayOne {
    public static void main(String[] args) {

//        int first = firstUniqChar("loveleetcode");
//        List<List<String>> anagrams = groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
        int arrayCount = subarraySum(new int[]{1,1,1,},2);
        System.out.println(arrayCount);
    }

    public static int firstUniqChar(String s) {
        // your code
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        char[] charArray = s.toCharArray();
        for (char c : s.toCharArray()) {
            if (charCount.containsKey(c)) {
                int val = charCount.get(c);
                val++;
                charCount.put(c, val);
            } else {
                charCount.put(c, 1);
            }
        }


        charCount.forEach((key, value) -> System.out.println(key + " = " + value));

        List<Map.Entry<Character, Integer>> list = charCount.entrySet().stream()
                .filter(e ->e.getValue() == 1)
                .collect(Collectors.toList());

        for(Map.Entry<Character, Integer> entry : charCount.entrySet() ){
            if(entry.getValue() == 1){
                return s.indexOf( entry.getKey());
            }
        }
        return -1;
    }


    public static int subarraySum(int[] nums, int k) {
        // your code
        Map<Integer, Integer> seen = new HashMap<>();
        int count= 0;
        int sum = 0 ;
        seen.put(0, 1);
        for (int temp: nums) {
            sum += temp;
            int key = seen.getOrDefault(sum - k, 0);
            if (key != 0)
                count++;
            seen.merge(sum, 1, Integer::sum);
        }
        return count;
    }



}
