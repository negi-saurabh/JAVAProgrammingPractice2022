package hackerRank.stringmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SherlockAndTheValidString {

    public static String isValid(String s) {
        // Write your code here
        int tick = 0;
        Map<Character, Integer> numberOfChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if(numberOfChars.containsKey(key)){
                int times = numberOfChars.get(key);
                times = times+1;
                numberOfChars.put(key, times);
            }else{
                numberOfChars.put(key, 1);
            }
        }

        for (int i = 0; i < s.length()-1; i++) {
            char temp = s.charAt(i);
            char nextTemp = s.charAt(i+1);
            int value = numberOfChars.get(temp);
            int nextValue = numberOfChars.get(nextTemp);
            if(Math.abs(value-nextValue)>1){
               tick = Math.abs(value-nextValue);
               break;
            }
            if(Math.abs(value-nextValue)==1)
            {
                tick++;
            }
        }
        return tick>1?"NO":"YES";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String result = isValid(s);
        System.out.println(result);
        bufferedReader.close();
    }
}
