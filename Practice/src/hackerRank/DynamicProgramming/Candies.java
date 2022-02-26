package hackerRank.DynamicProgramming;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'candies' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER n
	 *  2. INTEGER_ARRAY arr
	 */

	public static long candies(int n, List<Integer> arr) {

		// Write your code here
		int count = 0;
		int length = arr.size();
		int candies = 1;
		int sum = 1;
		int leftOverCandies = 0;
		for (int i = 1; i < length; i++) {

			if(arr.get(i) > arr.get(i-1))
			{
				if(count>0) {
					leftOverCandies = count*(count+1)/2;
					sum  = sum +leftOverCandies;
					candies = count;
				}
				candies++;
				sum  = sum + candies;
			}
			else if(arr.get(i) == arr.get(i-1)) {
				sum  = sum + (candies-1);
			}
			else {
				count++;
			}
		}

		return sum;
	}

}

public class Candies {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
			try {
				return bufferedReader.readLine().replaceAll("\\s+$", "");
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		})
				.map(String::trim)
				.map(Integer::parseInt)
				.collect(toList());

		long result = Result.candies(n, arr);

		bufferedReader.close();
		System.out.println(result);
	}
}

