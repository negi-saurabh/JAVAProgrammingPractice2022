package leetcode.medium.array;

import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

public class JumpGame2 {

	public static int canJump(Integer[] nums) {
		
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] inputArray = reader.readLine().replaceAll("\\s+$", "").split(",");
		List<Integer> a = Stream.of(inputArray).map(Integer::parseInt).collect(toList());
		System.out.print(canJump(a.toArray(new Integer[a.size()])));
	}

}
