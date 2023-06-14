package leetcode.easy.DP;

public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {

        int[] stepCost = new int[cost.length+1];
        stepCost[0] = cost[0];
        stepCost[1] = cost[1];
        for(int i = 2 ; i <= cost.length ; i++){
            if(i==cost.length){
                stepCost[i] = Math.min(stepCost[i-1], stepCost[i-2]);
            }else{
                stepCost[i] = cost[i] + Math.min(stepCost[i-1], stepCost[i-2]);
            }
        }
        return stepCost[stepCost.length -1 ];
    }

    public static void main(String[] args) {
        new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10,15,20});
    }

}
