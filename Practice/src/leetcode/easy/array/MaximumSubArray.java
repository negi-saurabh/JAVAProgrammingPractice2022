package leetcode.easy.array;

public class MaximumSubArray {

	public static void main(String[] args) {
		System.err.println(maxSubArray(new int[] {1, -2, 3, -4}));
	}

	public static int maxSubArray(int[] nums) {
		int sum = Integer.MIN_VALUE;
		int max = 0;
		for(int num : nums) {
			max = max + num;
			if(max>sum) {
				sum = max;
			}
			if(max < 0)
				max = 0;
		}
		return sum;
	}

}
