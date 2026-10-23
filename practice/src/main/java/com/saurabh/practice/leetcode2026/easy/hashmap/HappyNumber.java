package com.saurabh.practice.leetcode2026.easy.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while( n != 1){
            if (seen.contains(n)) {
                return false;
            }

            seen.add(n);
            n = getSum(n);
        }
        return true;

    }

    private int getSum(int n){
        int sum = 0;
        while (n > 0) {
            int lastDigit = n % 10;
            sum += lastDigit*lastDigit;
            n =  n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(19));
    }
}
