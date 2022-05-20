package leetcode.easy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidAnagram {

	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		int[] charArray = new int[27];
		for (int i = 0; i < s.length(); i++) {
			int current = s.charAt(i) - 'a' + 1;
			charArray[current]++;
		}
		
		for (int i = 0; i < t.length(); i++) {
			int current = t.charAt(i) - 'a' + 1;
			if(charArray[current] == 0) {
				return false;
			}else {
				charArray[current]--;
			}
		}
		return true;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String t = reader.readLine();
		boolean canIt = isAnagram(s, t);
	}

}
