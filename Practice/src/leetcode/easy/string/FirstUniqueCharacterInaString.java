package leetcode.easy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterInaString {

	public static int firstUniqChar(String s) {
		Map<Character, Integer> occurence = new HashMap<Character, Integer>(); 
		if(s.length() == 0) {
			return 0;
		}

		for (int i = 0; i < s.length(); i++) {
			char key = s.charAt(i);
			if(occurence.containsKey(key)) {
				int val = occurence.get(key);
				val = val +1;
				occurence.put(key, val);
			}else {
				occurence.put(key, 1);
			}
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(occurence.get(s.charAt(i)) == 1) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString = reader.readLine(); 
		int indexOfUniChar = firstUniqChar(inputString);
		System.err.println(indexOfUniChar);
	}

}
