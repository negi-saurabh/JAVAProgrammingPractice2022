package com.saurabh.practice.leetcode2026.easy.bitmanipulation;

public class AddBinary {

    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("11", "1"));
    }
}
