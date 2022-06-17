package leetcode.easy.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeNumber {

	public boolean isPalindrome(int x) {
		String input = Integer.toString(x);
		int k = input.length()-1;
		for (int i = 0; i<=k; i++) {
			if(i==k) {
				return true;
			}
			if(input.charAt(i) == input.charAt(k)) {
				k--;
				continue;
			}else {
				return false;
			}
			
		}
		
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String number = reader.readLine();
		System.out.println(new PalindromeNumber().isPalindrome(Integer.parseInt(number)));
	}

}
