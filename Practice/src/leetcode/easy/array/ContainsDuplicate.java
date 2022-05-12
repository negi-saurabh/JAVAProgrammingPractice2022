package leetcode.easy.array;

import java.util.Arrays;

public class ContainsDuplicate {
	public static void main(String[] args) {
		 System.err.println(containsDuplicate(new int[] {1, 2, 3, 4}));
	}
	
	  public static boolean containsDuplicate(int[] nums) {
		  	// hash map with values and number of time
		  	// sorting and checking if two number are consecutive
		  	// copying into list and checking contains before adding the number in to the list 
		  	// using set. If set contains the number, its returns false
		  	Arrays.sort(nums);
	        for (int i = 0; i < nums.length-1; i++) {
				 if(nums[i]==nums[i+1])
					 return true;
			}
	        return false;
	    }
}
