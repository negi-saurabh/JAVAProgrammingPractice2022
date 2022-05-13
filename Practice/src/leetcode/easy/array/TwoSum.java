package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSum {

	public static int[] twoSum(int[] nums, int target) {
		int index1 = 0;
		int index2 = 0;
		int next = 0;
		for (int i = 0; i < nums.length; i++) {
			if(index2!=0)
				break;
			index1 = i;
			next = target - nums[i];
			for (int j = i+1; j < nums.length; j++) {
				if(next==nums[j]) {
					index2 = j;
					break;
				}
			}
		}
		return new int[]{index1, index2};
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}
		int target = Integer.parseInt(reader.readLine());
		int[] result = twoSum(intInput, target);
	}
}
