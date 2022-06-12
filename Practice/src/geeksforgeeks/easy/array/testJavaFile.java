package geeksforgeeks.easy.array;

import java.util.ArrayList;

public class testJavaFile {
	public static void main(String args[]) {
		int n = 42;
		int s = 468;
		int arr[] = { 135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103,
				154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134 };
		
		ArrayList<Integer> output = new ArrayList<Integer>();
		int sum = 0;
		int startNum = 0;
		int stopNum = 0;
		for (int i = 22; i < n; i++) {
			stopNum = i;
			if (sum < s)
				sum = sum + arr[i];
			if (sum == s) {
				output.add(startNum + 1);
				output.add(stopNum + 1);
				break;
			} else if (sum > s) {
				sum = sum - arr[startNum];
				startNum = startNum + 1;
				if (sum == s) {
					output.add(startNum + 1);
					output.add(stopNum + 1);
					break;
				}
			}
		}
		if (output.isEmpty())
			output.add(-1);
	}
}