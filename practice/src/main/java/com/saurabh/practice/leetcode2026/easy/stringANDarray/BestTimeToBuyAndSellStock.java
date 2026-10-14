package com.saurabh.practice.leetcode2026.easy.stringANDarray;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxDifference = Integer.MIN_VALUE;

        for(int i=1; i < prices.length ; i++){
            maxDifference = Math.max(maxDifference, prices[i] - minPrice);
            minPrice = Math.min(minPrice,prices[i]);
        }

        return maxDifference <= 0 ? 0 : maxDifference;
    }

    public static void main(String[] args) {
        new BestTimeToBuyAndSellStock().maxProfit(new int[]{7,6,4,3,1});
    }
}
