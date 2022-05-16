package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSortedArray {

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] firstArray = new int[m];
		for (int i = 0 ; i < m ; i++){
			firstArray[i] = nums1[i];
		}
		for (int i = 0 ; i < (m<=n?m:n) ; i++){
			int t =  0;
			while(firstArray[i] <= nums2[i]) {
				nums1[i] = firstArray[i];
				t++;
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
		int target1 = Integer.parseInt(reader.readLine());
		String[] input1 = reader.readLine().split(",");
		int[] intInput1 = new int[input1.length];
		for (int i = 0; i < input1.length; i++) {
			intInput1[i] = Integer.parseInt(input1[i]);
		}
		int target2 = Integer.parseInt(reader.readLine());
		merge(intInput, target1, intInput1, target2);
	}
}
