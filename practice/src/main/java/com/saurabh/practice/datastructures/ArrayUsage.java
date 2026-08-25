package com.saurabh.practice.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayUsage {

//    Operation	                    Array	        ArrayList
//   ===========                   =======         ===========
//    Access by index	            O(1)	        O(1)
//    Search (unsorted)	            O(n)	        O(n)
//    Insert/remove at end		    O(1)            amortized
//    Insert/remove at start/middle	O(n) (shift)	O(n) (shift)

//    When to use:
//    you need indexed access, know the size roughly upfront,
//    and don't need to frequent insert/delete in the middle. Default choice for "give me a list of things."

//    When to avoid:
//    frequent insertions/deletions at the front or middle —
//    that's O(n) every time because everything shifts.

//    Interview tell:
//    if the problem says "reservations", "list of transactions", "array of prices"
//    — you're almost always looking at ArrayList or plain array + two pointers / sliding window.
    public static void main(String[] args) {
        // 1) Array - contiguous block of memory, fixed size
        int[] arr = new int[5];
        arr[3]= 3;
        Arrays.sort(arr);
        // 2) ArrayList - dynamic
        List<Integer> arrList = new ArrayList<>();
        arrList.add(1);
        arrList.remove(1);
        arrList.get(1);
        arrList.add(1, 4);
        arrList.isEmpty();
        arrList.contains(1);
        arrList.clear();
        arrList.indexOf(1);
        arrList.size();
        Collections.sort(arrList);

    }
}
