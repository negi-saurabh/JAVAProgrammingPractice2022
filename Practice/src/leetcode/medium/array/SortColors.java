package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SortColors {

	public static void sortColors(int[] nums) {
		int i = 0;
		int j = 0;
		int k = nums.length - 1;
		while(j<=k){
			if(nums[j] == 0){
				swap(nums,i,j);
				i++;
				j++;
			}
			else if(nums[j] == 2){
				swap(nums,j,k);
				k--;
			}
			else{
				j++;
			}
		}
	}
	public static void swap(int[] nums, int i,int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
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
