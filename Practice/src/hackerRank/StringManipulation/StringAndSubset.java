package hackerRank.StringManipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringAndSubset {
    private static String str = "aa,bb,cc,dd,ee,ff";
    private static List<String> allSubsets = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String[] temp = str.split(",");
        for (int i = 0; i < temp.length; i++) {
            makeSubset(allSubsets, temp[i]);
        }
        for (int i=0; i < allSubsets.size();i++){
            System.out.println(allSubsets.get(i));
        }
    }

    public static void makeSubset(List<String> allSubsets, String newStr){
        allSubsets.add(newStr);
        int length = allSubsets.size();
        for (int i = 0; i < length ; i++ ){
            if(!newStr.equals(allSubsets.get(i))) {
                String temp = allSubsets.get(i) + "," + newStr;
                if (!allSubsets.contains(temp))
                    allSubsets.add(temp);
            }
        }
    }
}
