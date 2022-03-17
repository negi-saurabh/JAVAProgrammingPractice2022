package hackerRank.arrays;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'hourglassSum' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts 2D_INTEGER_ARRAY arr as parameter.
	 */

	public static int hourglassSum(List<List<Integer>> arr) {
		// Write your code here
		Integer[][] newArr = arr.stream()
				.map(l -> l.stream().toArray(Integer[]::new))
				.toArray(Integer[][]::new);

		int sum = Integer.MIN_VALUE; ;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				sum = newArr[i][j] + newArr[i+2][j] + newArr[i][j+1] + newArr[i+1][j+1] + newArr[i+2][j+1] + newArr[i][j+2] + newArr[i+2][j+2];
				if(sum>max)
					max = sum;
				sum = Integer.MIN_VALUE;

			}
		}
		return max;
	}
}

public class TwoDimensionArray {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		List<List<Integer>> arr = new ArrayList<>();
		IntStream.range(0, 6).forEach(i -> {
			try {
				arr.add(
						Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
						);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});
		int result = Result.hourglassSum(arr);
		bufferedReader.close();
		System.out.println(result);
	}
}

