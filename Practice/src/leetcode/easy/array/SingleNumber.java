package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

	public int singleNumber(int[] nums) {
        int num=0;
        for(int val: nums){
            num=num^val;
        }
        return num;
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
