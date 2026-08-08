package prepforBoo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

}
