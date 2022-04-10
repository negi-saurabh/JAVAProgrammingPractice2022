package hackerRank.certification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TypeCounter {
    public static void typeCounter(String sentence) {
        int stringCount = 0;
        int intCount = 0;
        int doubleCount = 0;
        String[] strArr = sentence.split(" ");
        for (int i = 0; i < strArr.length; i++) {
                String temp = strArr[i];
            if(isInteger(temp))
                intCount++;
            else if(isDouble(temp))
                doubleCount++;
            else
                stringCount++;
        }
        System.out.println("string "+stringCount);
        System.out.println("integer "+intCount);
        System.out.println("double "+doubleCount);
    }

    public static boolean isDouble(String s){
        try{
            Double.parseDouble(s);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }
    public static boolean isInteger(String s){
        try{
            Integer.parseInt(s);
        }
        catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String sentence = bufferedReader.readLine();
        typeCounter(sentence);
        bufferedReader.close();
    }
}
