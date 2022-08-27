package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int totalProfit = 0;
		int interProfit = 0;
		int min = Integer.MAX_VALUE;
		boolean flag = false;

		for (int i = 0; i < prices.length-1; i++) {
			int currentDay = prices[i];
			int nextDay = prices[i+1];
			if(currentDay < nextDay) {
				min = Math.min(min, currentDay);
				interProfit = Math.max(interProfit, nextDay - min);
				flag = true;
			}if((currentDay > nextDay || i == prices.length-2) && flag) {
				totalProfit = totalProfit + interProfit;
				flag = false;
				min = Integer.MAX_VALUE;
				interProfit = 0;
			}
		}
		return totalProfit == 0 ? interProfit : totalProfit ;
	}


	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(",");
		int[] intInput = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			intInput[i] = Integer.parseInt(input[i]);
		}
		System.out.println(maxProfit(intInput));
	}
}
