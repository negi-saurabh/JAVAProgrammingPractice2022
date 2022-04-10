package hackerRank.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class IceCreamParlour {

	public static void whatFlavors(List<Integer> cost, int money) {
		// Write your code here
		int[] values = new int[2];
		List<Integer> newList = new ArrayList<>(cost.size());
		newList.addAll(cost);
		Collections.sort(newList);
		for (int i = 0; i < newList.size(); i++) {
			int value = money - newList.get(i);
			int uh = Collections.binarySearch(newList, value);
			if(Collections.binarySearch(newList, value)>=0){
				if(cost.indexOf(newList.get(i)) > cost.indexOf(value))
				{
					values[1] = newList.get(i);
					values[0] = value;
				} 
				else
				{
					values[0] = newList.get(i);
					values[1] = value;
				}
				break;
			}
		}
		System.out.print((cost.indexOf(values[0])+1));
		System.out.print(" ");
		System.out.print((cost.indexOf(values[1])+1));
		System.out.print("\n");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bufferedReader.readLine().trim());
		IntStream.range(0, t).forEach(tItr -> {
			try {
				int money = Integer.parseInt(bufferedReader.readLine().trim());
				int n = Integer.parseInt(bufferedReader.readLine().trim());
				List<Integer> cost = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList());

				whatFlavors(cost, money);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
	}
}
