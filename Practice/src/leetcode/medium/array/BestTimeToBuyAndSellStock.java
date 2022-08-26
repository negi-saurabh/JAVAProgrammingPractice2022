package leetcode.medium.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BestTimeToBuyAndSellStock {

	public static int maxProfit(int[] prices) {
		int min = prices[0];
		int max = prices[0];
		int totalProfit = 0;
		int profit = 0;
		
		for (int i = 1; i < prices.length; i++) {
			int priceOfTheDay = prices[i];
			if(max < priceOfTheDay) {
				profit = Math.max(profit, priceOfTheDay-min);
				min = Math.min(min, priceOfTheDay);
				max = Math.max(max, priceOfTheDay);
			}else if(max > priceOfTheDay) {
				totalProfit  = totalProfit + profit;
				max = 0;
			}else {
				min = priceOfTheDay;
			}
		}
		return totalProfit;
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
