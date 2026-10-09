package com.saurabh.javaprogrammingpractice;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        int i, j;

        i = 100;

        j = 300;

        while(++i < --j);

        System.out.println(i);

    }
}