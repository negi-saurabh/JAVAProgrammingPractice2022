//1. Frequency map & set dedup

import java.util.HashMap;
import java.util.Map;

public class Template{
    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<>();
        String str = "saurabh";
        char[] charArray = str.toCharArray();
        for(int i = 0 ; i < charArray.length; i++){
            char c = charArray[i];
            map.merge(c, 1, Integer::sum);
        }

        map.forEach((key, value) -> System.out.println("key and value  "+key+" " +value));
    }
}
