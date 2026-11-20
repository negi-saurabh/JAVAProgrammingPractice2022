package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // calculate a point from where we can start
        // maintain total and if it comes equal or more than 0
        // means the journey can be done
        // return 1 if returns else return -1

        int totalFuel = 0;
        int start = 0;
        int currentFuel = 0 ;

        for(int i = 0; i < gas.length; i++){
            int diff = gas[i] - cost[i];
            totalFuel += diff;
            currentFuel += diff;

            if(currentFuel<0){
                currentFuel = 0;
                start = i+1;
            }
        }
        return totalFuel >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        new GasStation().canCompleteCircuit(new int[]{5,1,2,3,4}, new int[]{4,4,1,5,1});
    }
}
