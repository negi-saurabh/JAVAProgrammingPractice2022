package hackerRank.stacksandqueue;

import java.io.*;
import java.util.*;

import static java.util.stream.Collectors.joining;

public class TaleOfTwoStacks {

	/*
	 * Complete the 'makeAnagram' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. STRING a
	 *  2. STRING b
	 */

	public static int makeAnagram(String a, String b) {

		int[] freq = new int[26];
		a.chars().forEach((c) -> {
			freq[c - 97]++;
		});
		b.chars().forEach((c) -> {
			freq[c - 97]--;
		});
		return Arrays.stream(freq).map(Math::abs).sum();}


	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String a = bufferedReader.readLine();
		String b = bufferedReader.readLine();
		int res = TaleOfTwoStacks.makeAnagram(a, b);
		System.out.println(res);
		bufferedReader.close();
	}
}
