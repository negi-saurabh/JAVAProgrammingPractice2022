package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class JumpGame2 {

    public int jump(int[] nums) {

        int farthest=0;
        int jump = 0;
        int currentEnd = 0;

        for(int i = 0; i < nums.length -1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i==currentEnd){
                jump++;
                currentEnd = farthest;
            }
        }

        return jump;
    }

    public static void main(String[] args) {
        new JumpGame2().jump(new int[]{2,3,1,1,4});
    }
}
