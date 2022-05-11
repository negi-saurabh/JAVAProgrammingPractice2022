package hackerRank.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


public class ArrayManipulation {

	public static long arrayManipulation(int n, List<List<Integer>> queries) {

		// Write your code here
		int numOfRows = queries.size();
		int[][] formedArray = new int[n][numOfRows+1];
		int max;
		for (int i = 1; i < formedArray.length; i++) {
			List<Integer> column = queries.get(i);

			int startIndex = queries.get(i).get(0)-1;
			int endIndex = queries.get(i).get(1)-1;
			int toInsert = queries.get(i).get(3)-1;

			for (int j = startIndex; j < endIndex; j++) {
				formedArray[i][j]= formedArray[i-1][j] + toInsert;
			}
			/*
			 * if(max<Collections.max(Arrays.asList(formedArray[i]))){
			 * 
			 * }
			 */
		}

		return n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		int n = Integer.parseInt(firstMultipleInput[0]);
		int m = Integer.parseInt(firstMultipleInput[1]);
		List<List<Integer>> queries = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String[] queriesRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
			List<Integer> queriesRowItems = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				int queriesItem = Integer.parseInt(queriesRowTempItems[j]);
				queriesRowItems.add(queriesItem);
			}
			queries.add(queriesRowItems);
		}
		long result = arrayManipulation(n, queries);
		bufferedReader.close();
	}
}
