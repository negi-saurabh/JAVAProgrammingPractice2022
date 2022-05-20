package leetcode.easy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;	

public class RansomNote {

	public static boolean canConstruct(String ransomNote, String magazine) {
		int[] charArray = new int[27];
		for (int i = 0; i < magazine.length(); i++) {
			int current = magazine.charAt(i) - 'a' + 1;
			charArray[current]++;
		}
		
		for (int i = 0; i < ransomNote.length(); i++) {
			int current = ransomNote.charAt(i) - 'a' + 1;
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
		String ransomnote = reader.readLine();
		String magazine = reader.readLine();
		boolean canIt = canConstruct(ransomnote, magazine);
	}
}
