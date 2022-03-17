package hackerRank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ClientInfoStatus;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

public class BubbleSort {
    class Result {
        /*
         * Complete the 'countSwaps' function below.
         *
         * The function accepts INTEGER_ARRAY a as parameter.
         */
        public static void countSwaps(List<Integer> a) {
            // Write your code here

            int numSwaps = 0;
            Integer[] arr = a.toArray(new Integer[0]);

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length-1; j++) {
                    if(arr[j] > arr[j+1]){
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                        numSwaps++;
                    }
                }
            }
            /*for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < a.size()-1; j++) {
                    if(a.get(j) > a.get(j+1)){
                        int temp = a.get(j);
                        a.add(j, a.get(j+1));
                        a.add(j+1, temp);
                        numSwaps++;
                    }
                }
            }*/

            int firstElement = arr[0];
            int lastElement = arr[arr.length-1];

            System.out.println("Array is sorted in "+ numSwaps +" swaps.");
            System.out.println("First Element: "+ firstElement );
            System.out.println("Last Element: "+ lastElement);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        Result.countSwaps(a);
        bufferedReader.close();
    }
}
