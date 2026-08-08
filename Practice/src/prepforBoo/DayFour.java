package prepforBoo;

import java.util.*;
import java.util.stream.Collectors;

public class DayFour {

    public static void main(String[] args) {

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



}
