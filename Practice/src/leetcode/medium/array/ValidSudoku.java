package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		Map<Character, Integer> valueTimes = new HashMap<>();
		List<Character> numberCheck;
		for (int i = 0; i < 9; i++) {
			numberCheck = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				char key = board[i][j];
				if (key == '.')
					continue;
				if(numberCheck.contains(key))
					return false;
				else
					numberCheck.add(key);
			}
		}

		for (int i = 0; i < 9; i++) {
			numberCheck = new ArrayList<>();
			for (int j = 0; j < 9; j++) {
				char key = board[j][i];
				if (key == '.')
					continue;
				if(numberCheck.contains(key))
					return false;
				else
					numberCheck.add(key);
			}
		}

		for (int l = 0; l < 9; l=l+3) {
			for (int k = 0; k < 9; k = k+3) {
				numberCheck = new ArrayList<>();
				for (int i = l ; i < l + 3; i++) {
					for (int j = k; j < k + 3; j++) {
						char key = board[i][j];
						if (key == '.')
							continue;
						if(numberCheck.contains(key))
							return false;
						else
							numberCheck.add(key);
					}
				}
			}
		}
		return true;
	}


	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[][] sudoku = { {'.','.','.','.','5','.','.','1','.'},
							{'.','4','.','3','.','.','.','.','.'},
							{'.','.','.','.','.','6','.','.','.'},
							{'8','.','.','.','.','.','.','2','.'},
							{'.','.','2','.','7','.','.','.','.'},
							{'.','1','5','.','.','.','.','.','.'},
							{'.','.','.','.','.','2','.','.','.'},
							{'.','2','.','9','.','.','.','.','.'},
							{'.','.','4','.','.','.','.','.','.'}};

		System.out.println(isValidSudoku(sudoku));
	}
}
