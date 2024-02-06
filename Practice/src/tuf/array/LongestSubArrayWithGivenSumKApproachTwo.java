package tuf.array;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubArrayWithGivenSumKApproachTwo {

    // wrong
    public static int lenOfLongSubarr(int A[], int N, int K) {
        //Complete the function
        int sum = 0;
        int maxLength = 0;
        for(int i=0,j = 0 ; j < N ; j++){
            sum = A[j];
            if(sum > K && i<=j)
            {
                sum -= A[i];
                i++;
            }
            if(sum == K ){
                maxLength = Math.max(maxLength, j-i);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 4, 3, 3, 5, 5};
        new LongestSubArrayWithGivenSumKApproachTwo().lenOfLongSubarr(input, 6, 16);
    }
}
