package com.saurabh.practice.leetcode2026.easy.dynamicprogramming;

public class ClimbingStairs {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return solve(n, memo);
    }

    private int solve(int n, int[] memo) {
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = solve(n - 1, memo) + solve(n - 2, memo);
        return memo[n];
    }
}
