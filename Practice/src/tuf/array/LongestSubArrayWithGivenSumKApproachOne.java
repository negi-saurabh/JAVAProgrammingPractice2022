package tuf.array;

import java.util.HashMap;
import java.util.Map;

import static java.lang.Math.max;

public class LongestSubArrayWithGivenSumKApproachOne {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 0, 0 , 0, 1, 1, 1, 1};
        int K = 3;
        System.out.println(lenOfLongSubarr(A, A.length, K));
    }

    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
        long sum = 0;
        int maxLength = 0;

        Map<Long, Integer> sumIndex = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long prefixSum = 0;
            sum += A[i];
            if(sum == K){
                maxLength = Math.max(i+1, maxLength);
            }
            prefixSum = sum - K;

            if(sumIndex.containsKey(prefixSum)){
                int len = i - sumIndex.get(prefixSum);
                maxLength = Math.max(len, maxLength);
                continue;
            }
            if (!sumIndex.containsKey(sum)) {
                sumIndex.put(sum, i);
            }
        }
        return maxLength;
    }
}
