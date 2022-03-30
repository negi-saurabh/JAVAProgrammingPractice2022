package hackerRank.greedyalgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;


public class LuckBalance {

	public static int luckBalance(int k, List<List<Integer>> contests) {

		// Write your code here
		int sum = 0;
		int remove = 0 ;
		List<List<Integer>> sortedContests = new ArrayList<List<Integer>>();
		List<Integer> listSorted = new ArrayList<Integer>();
		for (int i = 0; i < contests.size(); i++) {
			List<Integer> contest = contests.get(i);
			if(contest.get(1) == 1){
				listSorted.add(contest.get(0));
			}
		}
		Collections.sort(listSorted);

		for (int i = 0; i < listSorted.size() - k; i++) {
			int value = listSorted.get(i);
			for (int j = 0; j < contests.size(); j++) {
				List<Integer> contest = contests.get(j);
				if(contest.get(0) == value){
					remove = remove - contest.get(0);
					contests.remove(j);
				}
			}
		}

		for (int i = 0; i < contests.size(); i++) {
			List<Integer> contest = contests.get(i);
			sum = sum + contest.get(0);
		}
		return sum + remove;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
		int n = Integer.parseInt(firstMultipleInput[0]);
		int k = Integer.parseInt(firstMultipleInput[1]);

		List<List<Integer>> contests = new ArrayList<>();
		IntStream.range(0, n).forEach(i -> {
			try {
				contests.add(
						Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList())
						);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int result = luckBalance(k, contests);
		System.out.println(String.valueOf(result));
		bufferedReader.close();
	}

}
