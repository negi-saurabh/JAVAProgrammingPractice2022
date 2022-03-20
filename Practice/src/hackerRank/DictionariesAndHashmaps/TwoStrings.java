package hackerRank.dictionariesandhashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class TwoStrings {

	// Sample input
	// 6 5
	// two times three is not four
	// two times two is four

	class Result {
		public static String twoStrings(String s1, String s2) {
			// Write your code here
			Map<Character, Integer> subStringCheck = new HashMap<>();
			for (int i = 0; i < s1.length() ; i++) {
				char current = s1.charAt(i);
				if(subStringCheck.containsKey(current)){
					int number = subStringCheck.get(current);
					number = number +1;
					subStringCheck.put(current, number);
				}
				else
				{
					subStringCheck.put(current, 1);
				}
			}
			for (int i = 0; i < s2.length() ; i++) {
				char current = s2.charAt(i);
				if(subStringCheck.containsKey(current)){
					return "YES";
				}
			}
			return "NO";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(bufferedReader.readLine().trim());
		IntStream.range(0, q).forEach(qItr -> {
			try {
				String s1 = bufferedReader.readLine();

				String s2 = bufferedReader.readLine();

				String result = Result.twoStrings(s1, s2);

				System.out.println(result);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}

