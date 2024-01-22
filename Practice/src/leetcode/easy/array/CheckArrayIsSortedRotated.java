package leetcode.easy.array;

public class CheckArrayIsSortedRotated {

    public boolean check(int[] nums) {
        int breakIndex = 0;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] < nums[i-1]){
                breakIndex = i;
            }
        }
        for (int i = 1 ; i< breakIndex; i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        for (int i = breakIndex + 1 ; i < nums.length; i++){
            if(nums[i] < nums[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckArrayIsSortedRotated().check(new int[]{2,1,3,4}));
    }
}
