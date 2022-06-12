package geeksforgeeks.easy.array;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SubarrayWithGivenSum {

	static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
	{
		int sum = 0;
		boolean sumEquals = false;
		List<Integer> indexes = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			// if number is greater than sum required
			if(arr[i]>s) {
				sum = 0;
				continue;
			// if number is equal to sum required
			} else if (arr[i] == s) {
				indexes.removeAll(indexes);	
				indexes.add(i);
				sumEquals = true;
				// break so that we get the first and then exit
				break;
			}else {
				sum = sum + arr[i];
				if(sum < s) {
					indexes.add(i);
				} else if (sum == s) {
					indexes.add(i);
					sumEquals = true;
					// break so that we get the first and then exit
					break;
				}
				// start from the next index once sum overflows
				else 
				{
					i = indexes.get(0);
					sum = 0;
					indexes.removeAll(indexes);	
				}
			}
		}

		if(sumEquals) {
			result.add(indexes.get(0)+1);
			result.add(indexes.get(indexes.size()-1)+1);
		}else {
			result.add(-1);
		}
		return (ArrayList<Integer>) result;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\sane01\\Downloads\\h.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length]; 
		for (int i = 0; i < input.length; i++) 
		{ 
			intInput[i] =	Integer.parseInt(input[i]); 
		}
		System.out.println(new SubarrayWithGivenSum().subarraySum(intInput, intInput.length, 665));
		int[] arr = {1, 2, 3, 7, 5};
		//System.out.println(new SubarrayWithGivenSum().subarraySum(arr, arr.length, 12));
	}

}
