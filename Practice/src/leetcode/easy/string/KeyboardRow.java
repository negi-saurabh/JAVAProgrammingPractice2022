package leetcode.easy.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class KeyboardRow {

	public String[] findWords(String[] words) {
		List<String> wordList = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			String newWord = word.substring(1);
			newWord = newWord.substring(0, newWord.length()-1);
			if(isEligible(newWord.toLowerCase())) {
				wordList.add(word);
			}
		}
		
		return wordList.toArray(new String[wordList.size()]);
	}

	private boolean isEligible(String word) {
		List<String> keyboard1 = new ArrayList(){{add('q');add('w');add('e');add('r');add('t');add('y');add('u');add('i');add('o');add('p');}};
		List<String> keyboard2 = new ArrayList(){{add('a');add('s');add('d');add('f');add('g');add('h');add('j');add('k');add('l');}};
		List<String> keyboard3 = new ArrayList(){{add('z');add('x');add('c');add('v');add('b');add('n');add('m');}};
		boolean decider = true;
		
		for (int i = 0; i < word.length(); i++) {
			if(!keyboard1.contains(word.charAt(i))){
				decider = false;
				break;
			}
		}
		if(decider)
			return true;
		
		decider = true;
		for (int i = 0; i < word.length(); i++) {
			if(!keyboard2.contains(word.charAt(i))){
				decider = false;
				break;
			}
		}
		if(decider)
			return true;
		
		decider = true;
		for (int i = 0; i < word.length(); i++) {
			if(!keyboard3.contains(word.charAt(i))){
				decider = false;
				break;
			}
		}
		if(decider)
			return true;
		
		return false;
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");

		System.out.println(new KeyboardRow().findWords(input));
	}
}
