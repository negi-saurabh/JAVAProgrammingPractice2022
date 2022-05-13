package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MaximumSubArray {

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}
		System.err.println(maxSubArray(intInput));
	}

	public static int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int max = 0;
		for(int num : nums) {
			max = max + num;
			if(max>sum) {
				sum = max;
			}
			if(max < 0)
				max = 0;
		}
		return sum;
	}

}
