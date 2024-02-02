package leetcode.easy.array;

public class FindSingleNumberFromArray {

    public int singleNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1 ; i < nums.length ; i++){
            result = result ^ nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{0, 1, 0, 1, 1, 2, 3, 3, 2};
        new FindSingleNumberFromArray().singleNumber(intArr);
    }
}
