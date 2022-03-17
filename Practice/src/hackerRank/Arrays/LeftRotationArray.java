package hackerRank.arrays;

import static java.util.stream.Collectors.toList;
import java.io.*;
import java.util.*;
import java.util.stream.*;


public class LeftRotationArray {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int d = Integer.parseInt(firstMultipleInput[1]);
        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());
        List<Integer> result = LeftRotationArray.rotLeft(a, d);
        for(int i=0; i<result.size();i++)
        {
            System.out.print(result.get(i)+ " " );
        }
        bufferedReader.close();
    }

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        int arraySize = a.size();
        int[] tempArray = new int[arraySize];
        int diff = arraySize - d;

        for (int i = 0; i < arraySize; i++) {
            tempArray[i] = a.get(i);
        }

        for (int i = 0; i < arraySize; i++) {
            if (i < diff) {
                a.set(i, tempArray[i + d]);
            } else {
                a.set(i, tempArray[i - diff]);
            }
        }
        return a;
    }
}
