package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class BestTimeToBuyAndSellStock2 {

    public int maxProfit(int[] prices) {
        // iterate over prices
        // maintain a min price which compare and store the difference which should be max
        // maintain sum
        // we have to see unless the next lower value hits and we need to sell

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }

        return profit;

    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock2().maxProfit(new int[]{4,2,1,7});
    }
}
