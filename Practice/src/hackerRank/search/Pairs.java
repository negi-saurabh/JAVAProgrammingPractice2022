package hackerRank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Pairs {

    public static int pairs(int k, List<Integer> arr) {
        // Write your code here
        int count = 0;
        Collections.sort(arr);
        for (int i = 0; i < arr.size() ; i++) {
            int newValue = arr.get(i) + k;
            if(Collections.binarySearch(arr, newValue) >= 0)
                count++;
            int newValue2 = arr.get(i) - k;
            if(Collections.binarySearch(arr, newValue2) >= 0)
                count++;
        }
        return count/2;
    }

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = pairs(k, arr);

        System.out.println(String.valueOf(result));
        bufferedReader.close();
}
}

