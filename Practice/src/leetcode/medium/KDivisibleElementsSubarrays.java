package leetcode.medium;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import hackerRank.arrays.LeftRotationArray;

public class KDivisibleElementsSubarrays {

	  public int countDistinct(int[] nums, int k, int p) {
	        
	        for(int i = 0; i < nums.length ;i++)
	        {
	            for(int j = 0; j < nums.length ; j++)
	            {
	            }
	        }
	    }


	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
	        int n = Integer.parseInt(firstMultipleInput[0]);
	        int d = Integer.parseInt(firstMultipleInput[1]);
	        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
	                .map(Integer::parseInt)
	                .collect(toList());
	        List<Integer> result = LeftRotationArray.countDistinct(Collections.toArray(a)  , 1 , 2);
	        for(int i=0; i<result.size();i++)
	        {
	            System.out.print(result.get(i)+ " " );
	        }
	        bufferedReader.close();
	}

}
