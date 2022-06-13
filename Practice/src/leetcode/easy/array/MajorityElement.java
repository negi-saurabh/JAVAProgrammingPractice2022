package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> valueTimes = new HashMap<Integer, Integer>();
		int size = nums.length;
		if(size == 1)
			return nums[0];
		for (int i = 0; i < size; i++) {
			int key = nums[i];
			if(valueTimes.containsKey(key)) {
				int value = valueTimes.get(key);
				value++;
				if(value > size/2)
					return key;
				else
					valueTimes.put(key, value);
			}
			else
			{
				valueTimes.put(key, 1);
			}
		}
		return 0;
	}
	
	public int majorityElementFASTSOLUTION(int[] nums) {
        int me=nums[0];
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(count==0){
                me=nums[i];
            } 
            if(nums[i]==me){
                count++;
            } else{
                count--;
            }
        }
        return me;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]); 
		}

		System.out.println(new MajorityElement().majorityElementFASTSOLUTION(intInput));
	}

}
