package google.codejam;

import java.util.Locale;
import java.util.Scanner;

public class MoonsAndUmbrellas {

    public static char[] getString(char[] input)
    {
        int length = input.length;
        char[] resultArray = new char[length];

        for (int i = 0 ; i < length; i++)
        {
            if(i==0 && '?'== input[length-1])
            {
                resultArray[0] = input[1];
            }
            else if(i==length-1 && '?'== input[length-1])
            {
                resultArray[length-1] = input[length-2];
            }else if ('?'== input[i]) {
                    if('J'== input[i-1]  && 'J' == input[i+1]){
                        resultArray[i] = 'J';
                    } else if('C' == input[i-1]  && 'C'==input[i+1]){
                        resultArray[i] = 'C';
                    }
                    else
                        resultArray[i] = 'C';
                    }
            else{
                resultArray[i] = input[i];
            }
        }
        return resultArray;
    }

    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int testCases,n;
        int cjPrice, jcPrice, sum = 0;
        char a[];
        testCases=in.nextInt();

        for(int t=1;t<=testCases;t++){
            cjPrice =in.nextInt();
            jcPrice =in.nextInt();
            a=in.next().toLowerCase().toCharArray();
            char[] result = getString(a);
            int currentChar = result[0];
            for (int i = 1; i < result.length-1; i++) {
                    if(currentChar=='J'){
                        if(result[i] == 'J')
                        {
                            currentChar = 'j';
                        }else{
                                 sum = sum + jcPrice;
                        }
                    }else
                    {
                        if(result[i] == 'C')
                        {
                            currentChar = 'C';
                        }else{
                            sum = sum + cjPrice;
                        }
                    }
            }
            System.out.println("Case #" + Math.addExact(t, 1)  + ": " +sum);

        }

    }
}
