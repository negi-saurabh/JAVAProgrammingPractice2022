package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortColors {

	public static void sortColors(int[] nums) {
		if(nums == null || nums.length ==0)
			return;
		int zeros = 0;
		int ones = 0;
		int twos = 0;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i] == 0) {
				zeros++;
			}
			if(nums[i] == 1) {
				ones++;
			}
			if(nums[i] == 2) {
				twos++;
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(i>= 0 && i<zeros) {
				nums[i] = 0;
			}
			else if(i>=zeros && i< (zeros+ones)) {
				nums[i] = 1;
			}
			else if( i>=(zeros+ones) && i< (zeros+ones + twos)) {
				nums[i] = 2;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}
		sortColors(intInput);
	}

}
