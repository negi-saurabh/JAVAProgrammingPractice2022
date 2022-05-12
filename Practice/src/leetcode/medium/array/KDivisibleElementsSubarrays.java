package leetcode.medium.array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import hackerRank.arrays.LeftRotationArray;

public class KDivisibleElementsSubarrays {

	public static int countDistinct(Integer[] nums, int k, int p) {
		Set<List<Integer>> distintSubarrays = new HashSet<>();
		for(int i = 0; i < nums.length ;i++)
		{
			List<Integer> subArray = new ArrayList();
			int numberLimit = k+1;
			for(int j = i; j < nums.length ; j++)
			{
				if(nums[j]%p == 0) {
					numberLimit--;
				}
				if(numberLimit==0)
					break;
				subArray.add(nums[j]);
				distintSubarrays.add(new ArrayList<>(subArray));
			}
		}
		return distintSubarrays.size();
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArray = bufferedReader.readLine().replaceAll("\\s+$", "").split(",");
		List<Integer> a = Stream.of(inputArray).map(Integer::parseInt).collect(toList());
		int n = Integer.parseInt(bufferedReader.readLine()); 
		int d = Integer.parseInt(bufferedReader.readLine()); 
		try {
			System.out.print(countDistinct(a.toArray(new Integer[a.size()]), n, d));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bufferedReader.close();
	}

}
