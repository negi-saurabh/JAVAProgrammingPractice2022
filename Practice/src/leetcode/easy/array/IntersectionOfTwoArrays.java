package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class IntersectionOfTwoArrays {

	public static int[] intersect(int[] nums1, int[] nums2) {
		int res[]=new int[1001],count=0;
		for(int i : nums1) 
			res[i]++;
		for(int i : nums2){
			if(res[i] > 0){
				nums1[count++] = i;
				res[i]--;
			}
		}  
		return Arrays.copyOf(nums1,count);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]);
		}
		String[] input1 = reader.readLine().split(",");
		int[] intInput1 = new int[input1.length];
		for (int i = 0; i < input1.length; i++) {
			intInput1[i] = Integer.parseInt(input1[i]);
		}
		intersect(intInput, intInput1);
	}
}
