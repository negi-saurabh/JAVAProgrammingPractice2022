import java.util.*;

public class AlgoTemplate   {


    public static void main(String[] args) {

        // count number of characters in an array
        String str = "leetcode";
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : str.toCharArray())
            freq.merge(c, 1, Integer::sum);      // count
        Set<Integer> seen = new HashSet<>();

        //  Count signature — count letters into int[26], turn that into a key. No sorting.
        int[] cnt = new int[26];
        for (char c : str.toCharArray()) cnt[c - 'a']++;
        // build a key like "1#0#0#...#1#..." from cnt (a delimiter avoids "1,11" ambiguity)
        String key = Arrays.toString(cnt);
    }


}
