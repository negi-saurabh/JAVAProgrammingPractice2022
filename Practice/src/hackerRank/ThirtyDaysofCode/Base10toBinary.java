package hackerRank.ThirtyDaysofCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base10toBinary {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        
        
        String binaryNum = "";
        while(n>0){
        	int x = n%2;
            binaryNum = binaryNum+String.valueOf(x);
            n = n/2;
        }
        
        int count = 1;
        int tempCount  = 1; 
        for(int i=0; i < binaryNum.length(); i++){
            if(i!= 0 && binaryNum.charAt(i) == binaryNum.charAt(i-1))
            { 
                count = count + 1;
            }else{             
                count = 1;
            }
            if(count > tempCount)
                tempCount = count;
        }
        
        System.out.println(tempCount);
        bufferedReader.close();
    }

}
