package hackerRank.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class MarkAndToys {

    public static int maximumToys(List<Integer> prices, int k) {
        // Write your code here
        Collections.sort(prices);
        int numberOfGifts = 0;
        for (int i=0; i < prices.size(); i++){
            int valueOfEach = prices.get(i);
            if(k - valueOfEach>0){
                k = k - valueOfEach;
                numberOfGifts++;
            }
        }
        return numberOfGifts;
    }

    public static void main(String[] args) throws  IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int n = Integer.parseInt(firstMultipleInput[0]);
        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = maximumToys(prices, k);
        System.out.println(String.valueOf(result));
        bufferedReader.close();
    }
}
