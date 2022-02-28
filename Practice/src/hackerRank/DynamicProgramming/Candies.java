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
		int sum = 0;
		int[] frontTOback = new int[length];
		frontTOback[0] = 1;
		int[] backToFront = new int[length];
		backToFront[length-1] = 1;
		for (int i = 1; i < length; i++) {
			if(arr.get(i)>arr.get(i-1)) {
				candies++;
			}else {
				candies = 1;
			}
			frontTOback[i]=candies;
		}

		for (int i = length-2; i >-1; i--) {
			if(arr.get(i)>arr.get(i+1)) {
				candies++;
			}else {
				candies = 1;
			}
			backToFront[i] = candies;
		}

		for (int i = 0; i < backToFront.length; i++) {
			if(backToFront[i]>frontTOback[i]) {
				sum = sum + backToFront[i];
			}
			else {
				sum = sum + frontTOback[i];
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

