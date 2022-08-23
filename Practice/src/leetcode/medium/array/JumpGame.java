package leetcode.medium.array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class JumpGame {

	public static boolean canJump(Integer[] nums) {
		int currentLastJumpNeeds = 1;
		int totalJumpsNeeded = nums.length-1;
		if( nums[0] == 0) {
			return false;
		}
		if(totalJumpsNeeded==0) {
			return true;
		}
		for (int i = nums.length-1; i >= 0; i--) {
			if(i==0) {
				if(totalJumpsNeeded > nums[i])
					return false;
				else 
					return true;
			}else {
				if(nums[i-1] >= currentLastJumpNeeds) {
					totalJumpsNeeded = totalJumpsNeeded - currentLastJumpNeeds;
				}
				else {
					currentLastJumpNeeds++;
				}
			}
		}

		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArray = reader.readLine().replaceAll("\\s+$", "").split(",");
		List<Integer> a = Stream.of(inputArray).map(Integer::parseInt).collect(toList());
		System.out.print(canJump(a.toArray(new Integer[a.size()])));
	}

}
