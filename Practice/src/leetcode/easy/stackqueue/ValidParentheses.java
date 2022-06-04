package leetcode.easy.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidParentheses {

	public static  boolean isValid(String s) {
		Stack<Character> validCheck  = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			validCheck.push(current);
			if (current == ')' && !validCheck.isEmpty()) {
				if (validCheck.pop() != '(')
					return false;
			}
			else if (current == '}' && !validCheck.isEmpty()) {
				if (validCheck.pop() != '{')
					return false;
			}
			else if (current == ']' && !validCheck.isEmpty()) {
				if (validCheck.pop() != '[')
					return false;
			}
		}
		return validCheck.isEmpty();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = reader.readLine();
	}

}
