package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> valueTimes = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if(valueTimes.containsKey(key)) {
				valueTimes.remove(key);
			}
			else
			{
				valueTimes.put(key, 1);
			}
		}
		return (int) valueTimes.keySet().toArray()[0];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}

		System.out.println(new SingleNumber().singleNumber(intInput));
	}

}
