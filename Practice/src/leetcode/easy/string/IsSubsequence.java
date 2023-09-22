package leetcode.easy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class IsSubsequence {

	public static boolean isSubsequence(String s, String t) {

		int sIndex = 0;
		if (s.length()<1){
			return true;
		}
		for (int i = 0; i < t.length(); i++) {
			if (t.charAt(i) == s.charAt(sIndex)) {
				sIndex++;
			}
			if (sIndex == s.length())
				return true;
		}
		return false;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String s = reader.readLine();
		String t = reader.readLine();
		boolean canIt = isSubsequence(s, t);
	}

}
