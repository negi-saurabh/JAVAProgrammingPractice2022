package tuf.array;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubArrayWithGivenSumKApproachOne {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1, 1, 1, 1};
        int sum = 3;
        int tempSum = 0;
        int maxLength = 0 ;
        Map<Integer, Integer> sumIndexMap = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
             tempSum =+ input[i];
             if(sum == tempSum){
                 maxLength= max(maxLength, i+1);
             }
             int rem = tempSum - sum;
             if(sumIndexMap.containsKey(rem)){
                    int len = i-sumIndexMap.get(rem);
                    maxLength= max(maxLength, len);
             }
            sumIndexMap.put(tempSum, i);
        }
        System.out.println("Length is "+ maxLength );
    }
}
