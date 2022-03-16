package hackerRank.DictionariesAndHashmaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public class HashTablesRansomNote {

	class Result {

	    /*
	     * Complete the 'checkMagazine' function below.
	     *
	     * The function accepts following parameters:
	     *  1. STRING_ARRAY magazine
	     *  2. STRING_ARRAY note
	     */

	    public static void checkMagazine(List<String> magazine, List<String> note) {
	    // Write your code here
	    	Hashtable<String, Integer> wordTable = new Hashtable<>();
	    	boolean isPossible = true;
	    	for (int i = 0; i < magazine.size(); i++) {
	    		String key = magazine.get(i);
	    		if(wordTable.containsKey(key))
	    		{
	    			int value = wordTable.get(key);
	    			value = value +1 ;
	    			wordTable.put(key, value);
	    		}else
	    			wordTable.put(magazine.get(i), 1);
			}
	    	
	    	for (int i = 0; i < note.size(); i++) {
	    		String key = note.get(i);
				if(!wordTable.containsKey(key)) {
					isPossible =false;
				}else {
					if(wordTable.get(key)==1)
					{
						wordTable.remove(note.get(i));
					}else {
						int value = wordTable.get(key);
		    			value = value -1 ;
		    			wordTable.put(key, value);
					}
					
				}
			}
	    	if(isPossible)
	    		System.out.println("Yes");
	    	else {
	    		System.out.println("No");
	    	}
	    }

	}
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

	        int m = Integer.parseInt(firstMultipleInput[0]);

	        int n = Integer.parseInt(firstMultipleInput[1]);

	        List<String> magazine = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

	        List<String> note = Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "));

	        Result.checkMagazine(magazine, note);

	        bufferedReader.close();
	    }
}
