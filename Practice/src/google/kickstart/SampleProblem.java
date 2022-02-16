package google.kickstart;

import java.util.Scanner;

public class SampleProblem {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int T = in.nextInt();
			
			for (int t = 1; t <= T; ++t) {
				int bags = in.nextInt();
				int kids = in.nextInt();
				int candies =0;
				for (int i = 0; i < bags; i++) {
					candies = candies + in.nextInt();
				}
				System.out.println(
						"Case #" + t + ": " + candies%kids );
			}
		}}

}
