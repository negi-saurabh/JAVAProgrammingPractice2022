package hackerRank.recursionAndbacktracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class DavisStaircase {

	public static int[] values = new int[40];
	public static int stepPerms(int n) {
		// Write your code here

		if(n<4)
			return values[n];
		else if(values[n]>0)
			return values[n];
		else {
			values[n] = stepPerms(n-1) + stepPerms(n-2)+ stepPerms(n-3);
			return values[n];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(bufferedReader.readLine().trim());
		DavisStaircase.values[0]=0;
		DavisStaircase.values[1]=1;
		DavisStaircase.values[2]=2;
		DavisStaircase.values[3]=4;
		IntStream.range(0, s).forEach(sItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				int res = DavisStaircase.stepPerms(n);
				System.out.println(String.valueOf(res));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

	}
}
