package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i][matrix[i].length-1]>=target) {
				row = i;
				break;
			}
		}
		int[] column = matrix[row];
		for (int i = 0; i < column.length; i++) {
			if(column[i] == target)
				return true;
		}
		return false;
	}


	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int[][] intInput = {
				{1},
				{3}
		};

		searchMatrix(intInput, 1);
	}
}
