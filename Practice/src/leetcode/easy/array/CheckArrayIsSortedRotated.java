package leetcode.easy.array;

public class CheckArrayIsSortedRotated {

    public boolean check(int[] nums) {
        int breakIndex = 0;
        for(int i = 1; i < nums.length;i++){
            if(nums[i] < nums[i-1]){
                breakIndex = i;
            }
        }

        int[] orderedArray = new int[nums.length];
        for (int i = 0; i < orderedArray.length; i++) {
            orderedArray[i] = nums[(i+breakIndex) % orderedArray.length];
        }

        for (int i = 1; i < orderedArray.length; i++) {
            if(orderedArray[i] < orderedArray[i-1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CheckArrayIsSortedRotated().check(new int[]{2,1,3,4}));
    }
}
