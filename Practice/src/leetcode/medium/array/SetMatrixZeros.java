package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SetMatrixZeros {

	public static void setZeroes(int[][] matrix) {
		List<Integer> rowZeros = new ArrayList();
		List<Integer> columnZeros = new ArrayList();
		
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			for (int j = 0; j < row.length; j++) {
				if(row[j] == 0) {
					columnZeros.add(j);
					rowZeros.add(i);
				}
			}
		}

	}



	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int[][] intInput = {
				{1, 1, 1},
				{1, 0, 1},
				{1, 1, 1}
		};

		setZeroes(intInput);
	}
}
