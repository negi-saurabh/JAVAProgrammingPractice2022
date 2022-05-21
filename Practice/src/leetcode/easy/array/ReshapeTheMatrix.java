package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReshapeTheMatrix {

	public static int[][] matrixReshape(int[][] mat, int r, int c) {
		int[][] reshaped = new int[r][c];
		int totalSize = 0;
		
		for (int i = 0; i < mat.length; i++) {
			int[] row = mat[i];
			totalSize = totalSize + row.length;
		}
		
		if(totalSize < (r*c))
			return mat;
		
		
		return reshaped;
	}

	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		int[][] intInput = {
				{1, 2},
				{3, 4}
		};

		matrixReshape(intInput, 1, 4);
	}

}
