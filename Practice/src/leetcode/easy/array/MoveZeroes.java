package leetcode.easy.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length >= 1){
            for(int i = 0; i < nums.length; i++){
                if(nums[i]== 0){
                    int j = 0;
                    int temp = 0;
                    while(nums[i+j] == 0 && (i+j) < nums.length -1 )
                    {
                        j++;
                    }
                    temp = nums[i];
                    nums[i] = nums[i+j];
                    nums[i+j] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] intArr = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(intArr);
    }
}
