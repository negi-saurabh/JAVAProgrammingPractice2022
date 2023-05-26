package leetcode.easy.DP;

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] stepCount = new int[n+3];
        stepCount[0] = 0;
        stepCount[1] = 1;
        stepCount[2] = 2;
        stepCount[3] = 3;

        for(int i = 4; i<=n ; i++){
            stepCount[i] =  stepCount[i-1] + stepCount[i-2];
        }

        return  stepCount[n];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(45));
    }
}
