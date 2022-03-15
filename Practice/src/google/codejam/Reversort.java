package google.codejam;

import java.util.Scanner;
import java.util.Arrays;
import java.lang.*;
public class Reversort {


	private static int reverSort(int[] numberArray, int numberOfelements) {
		// TODO Auto-generated method stub
		int smallest = Integer.MAX_VALUE;
		int cost = 0;
		int costPerIter = 0;
		for (int i = 0; i < numberOfelements-1; i++) {
			smallest = getSmallestNumberIndex(Arrays.copyOfRange(numberArray, i, numberOfelements));
			smallest = smallest + i;
			costPerIter = smallest-i+1;
			cost = cost + costPerIter;
			Arrays.sort(numberArray, i, smallest+1);
		}
		return cost;
	}

	public static int getSmallestNumberIndex(int[] givenArray) {
		int i=0;
		int smallest = Integer.MAX_VALUE;
		int smallestIndex = 0;

		while(i < givenArray.length) {
			if(smallest>givenArray[i]) {
				smallest = givenArray[i];
				smallestIndex = i;
			}
			i++;
		}
		return smallestIndex;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// Get number of test cases in input
		int testCaseCount = scanner.nextInt();
		int[] results = new int[testCaseCount];
		// Iterate through test cases
		for (int tc = 1; tc <= testCaseCount; ++tc) {
			// Get number of papers for this test case
			int numberOfelements = scanner.nextInt();
			// Get number of citations for each paper
			int[] numberArray = new int[numberOfelements];
			for (int p = 0; p < numberOfelements; ++p) {
				numberArray[p] = scanner.nextInt();
			}
			results[tc-1] = reverSort(numberArray, numberOfelements);
		}
		
		for (int i = 0; i < results.length; i++) {
			System.out.println("Case #" + Math.addExact(i, 1)  + ": " +results[i]);
		}
	}
}
