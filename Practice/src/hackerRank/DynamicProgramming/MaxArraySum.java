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

public class MaxArraySum {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}
		int res = maxSubsetSum(arr);
	}



	static int maxSubsetSum(int[] arr) {

		int length = arr.length;
		int inc = arr[0];
		int exl= 0;
		int oldInc = 0;
		for(int i=1; i<length; i++) {
			oldInc = inc;
			inc= Math.max(inc, (exl + arr[i]));
			exl = oldInc;
		}

		return inc > exl ? inc:exl;


	}
}

