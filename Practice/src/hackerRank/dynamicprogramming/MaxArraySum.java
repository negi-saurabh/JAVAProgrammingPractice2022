package hackerRank.dynamicprogramming;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

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
		for(int i=0; i<length; i++) {
			for(int j=i+2;j<length;j++) {

			}
		}

		return 0;


	}
}

