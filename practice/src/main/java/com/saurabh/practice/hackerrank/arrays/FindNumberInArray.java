package com.saurabh.practice.hackerrank.arrays;

import java.io.*;
import java.util.List;

class Test {

    public static String findNumber(List<Integer> arr, int k) {
        int length = arr.get(0);
        for (int i = 1 ; i < length ;i++)
        {
            if(arr.get(i) == k)
                return "YES";

        }
        return "NO";
    }
}

public class FindNumberInArray {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = List.of(5, 1, 2, 3, 4, 5);
        String result = Test.findNumber(arr, 1);

    }
}