package com.saurabh.practice.prepforboo;

import java.util.*;

public class DayFour {

    public static void main(String[] args) {

        String str = "saurabh";
        System.out.println(str.substring(2));
        System.out.println(str.substring(0, 2));
//        List<List<String>> groupedList = groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
//        groupedList.stream().forEach(a-> System.out.println(a));
    }

    public static boolean validAnagram(String one, String two){
        if(one.length() != two.length())
            return false;
        Map<Character, Integer> charCount = new HashMap<>();
        for(int i = 0 ; i< one.length(); i++){
            charCount.merge(one.charAt(i), 1, Integer::sum);
            charCount.merge(two.charAt(i), 1, Integer::sum);
        }
        return charCount.values().stream()
                .allMatch(count -> count % 2 == 0);

    }

    public static boolean containsDuplicates(int[] arr){
        Set set = new HashSet();
        for(int i = 0 ; i < arr.length ;i ++){
            int val = arr[i];
            if(set.contains(val))
                return true;

            set.add(val);
        }
        return false;
    }

    public static boolean ransomNote(String magazine, String note){
        Map<Character, Integer> magazineArray = new HashMap<>();
        for (char s: magazine.toCharArray()) {
                magazineArray.merge(s, 1, Integer::sum);
        }

        for (char s: note.toCharArray()) {
            if(magazineArray.getOrDefault(s, 0) == 0) {
               return false;
            }
            magazineArray.merge(s, -1, Integer::sum);
        }
        return true;
    }

    public static int firstUniqueCharacter(String str){
        Map<Character, Integer> characterIntegerMap = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            characterIntegerMap.merge(c, 1, Integer::sum);
        }

        Optional<Map.Entry<Character, Integer>> first = characterIntegerMap.entrySet()
                .stream().filter(e -> e.getValue() == 1).findFirst();

        Map.Entry<Character, Integer> firstEntry  = first.isPresent() ? first.get() : null;
        return firstEntry != null ? str.indexOf(firstEntry.getKey()): -1 ;
    }

    public static Set<Integer> arrayIntersection(int[] arr1, int[] arr2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        for (int n : arr1) {
            set.add(n);
        }

        for (int n : arr2) {
            if (set.contains(n)) {
                result.add(n);
            }
        }

        return result;
    }

    public static List<List<String>> groupAnagrams(String[] arr){
        Map<String, List<String>> groupedMap = new HashMap<>();
        for (String i : arr ) {
            int[] charArray = new int[26];
            for (char c : i.toCharArray()) {
                charArray[c - 'a']++;
            }
            String val = Arrays.toString(charArray);
            groupedMap.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }

        return new ArrayList<>(groupedMap.values());
    }


}
