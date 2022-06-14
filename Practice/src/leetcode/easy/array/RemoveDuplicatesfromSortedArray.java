package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesfromSortedArray {

	public int removeDuplicates(int[] nums) {
		int count = 1;
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] == nums[i+1]) {
				continue;
			}else {
				count++;
			}
			nums[count-1] = nums[i+1];
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}

		System.out.println(new RemoveDuplicatesfromSortedArray().removeDuplicates(intInput));
	}


}
