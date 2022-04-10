package hackerRank.certification;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultiSum
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] in = reader.readLine().replaceAll("\\s+$", "").split(" ");
        if(isInteger(in[0])){
            Integer[] intArr = new Integer[in.length];
            for (int i=0; i < in.length ; i++){
                intArr[i] = Integer.parseInt(in[i]);
            }
            System.out.println(new Arithmetic().sum(intArr));
        }else{
            System.out.println(new Arithmetic().sum(in));
        }
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
}

class Arithmetic{

    public String sum(String[] arr){
        String totalString = "";
        for (int i = 0; i < arr.length; i++) {
            totalString = totalString + arr[i];
        }
        return totalString;
    }
    public int sum(Integer[] arr){
        int totalInt = 0;
        for (int i = 0; i < arr.length; i++) {
            totalInt = totalInt + arr[i];
        }
        return totalInt;
    }

}

