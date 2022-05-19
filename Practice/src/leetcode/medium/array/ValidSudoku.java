package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		Map<Character, Integer> valueTimes = new HashMap<>();

		for (int i = 0; i < board.length; i++) {
			char key = board[i][0];
			if (key == '.')
				continue;
			if(valueTimes.containsKey(key)) {
				int val = valueTimes.get(key);
				val = val +1;
				valueTimes.put(key, val);
			}else {
				valueTimes.put(key, 1);
			}
		}
		if(valueTimes.containsValue(2))
			return false;

		valueTimes = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			char key = board[0][i];
			if (key == '.')
				continue;
			if(valueTimes.containsKey(key)) {
				int val = valueTimes.get(key);
				val = val +1;
				valueTimes.put(key, val);
			}else {
				valueTimes.put(key, 1);
			}
		}
		if(valueTimes.containsValue(2))
			return false;


		for (int k = 0; k < 3; k++) {
			for (int i = k; i < 3; i++) {
				valueTimes = new HashMap<>();
				for (int j = 0; j < 3; j++) {
					char key = board[i][j];
					if(valueTimes.containsKey(key)) {
						int val = valueTimes.get(key);
						val = val +1;
						valueTimes.put(key, val);
					}else {
						valueTimes.put(key, 1);
					}
				}
				if(valueTimes.containsValue(2))
					return false;
			}
			k++;
			k++;
		}

		return true;
	}


	public static void main(String[] args) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4','1','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};

		boolean result = isValidSudoku(sudoku);
	}

}
