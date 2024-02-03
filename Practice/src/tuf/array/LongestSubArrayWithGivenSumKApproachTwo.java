package tuf.array;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubArrayWithGivenSumKApproachTwo {
    public static int lenOfLongSubarr(int A[], int N, int K) {
        //Complete the function
        int sum = A[0];
        int maxLength = 0;
        if(sum == K){
            maxLength = 1;
        }
        int count = 1;
        for(int i = 1 ; i < A.length ; i++){
            sum += A[i];
            count ++;
            if(sum == K){
                maxLength = Math.max(maxLength, count);
                sum = 0;
                count = 0;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 3, 3, 5, 5};
        new LongestSubArrayWithGivenSumKApproachTwo().lenOfLongSubarr(input, 6, 16);
    }
}
