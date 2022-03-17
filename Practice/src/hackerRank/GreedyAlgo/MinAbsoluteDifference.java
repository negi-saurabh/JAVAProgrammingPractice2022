package hackerRank.greedyalgo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.joining;


public class MinAbsoluteDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
				.map(Integer::parseInt)
				.collect(toList());

		int result = MinAbsoluteDifference.minimumAbsoluteDifference(arr);
		bufferedReader.close();
		System.out.println(result);
	}

	public static int minimumAbsoluteDifference(List<Integer> arr) {
		// Write your code here
		Collections.sort(arr);
		int min =  Math.abs(arr.get(0)-arr.get(1));
		for(int i=1; i < arr.size() ; i++){
			int diff = Math.abs(arr.get(i)-arr.get(i-1));
			if(diff<min)
				min = diff;
		}
		return min;

	}

}
