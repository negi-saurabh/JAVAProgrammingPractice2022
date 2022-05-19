package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {

	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> mappingNum1 = new HashMap<>();
		Map<Integer, Integer> mappingNum2 = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			int key = nums1[i];
			if(mappingNum1.containsKey(key)) {
				int val = mappingNum1.get(key);
				val = val +1;
				mappingNum1.put(key, val);
			}else {
				mappingNum1.put(key, 1);
			}
		}

		for (int i = 0; i < nums2.length; i++) {
			int key = nums2[i];
			if(mappingNum2.containsKey(key)) {
				int val = mappingNum2.get(key);
				val = val +1;
				mappingNum2.put(key, val);
			}else {
				mappingNum2.put(key, 1);
			}
		}

		List<Integer> intersectedList = new ArrayList<>();
		if(nums1.length - nums2.length > 0) {
			for (int i = 0; i < nums2.length; i++) {
				int key = nums2[i];
				if(mappingNum1.containsKey(key)) {
					intersectedList.add(nums2[i]);
					int val = mappingNum1.get(key);
					val = val - 1;
					if(val==0)
						mappingNum1.remove(key);
					else
						mappingNum1.put(key, val);
				}
			}
		}else {
			for (int i = 0; i < nums1.length; i++) {
				int key = nums1[i];
				if(mappingNum2.containsKey(nums1[i])) {
					intersectedList.add(nums1[i]);
					int val = mappingNum2.get(key);
					val = val - 1;
					if(val==0)
						mappingNum2.remove(key);
					else
						mappingNum2.put(key, val);
				}
			}
		}
		return intersectedList.stream().mapToInt(i -> i).toArray();
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
