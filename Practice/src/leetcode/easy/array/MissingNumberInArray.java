package leetcode.easy.array;

public class MissingNumberInArray {

    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sumOfArray = 0;
        int expectedSum = (length * (length+1))/2;
        for (int i=0; i < length ; i++){
            sumOfArray  += nums[i];
        }

        return (expectedSum - sumOfArray );
    }

    public static void main(String[] args) {
        int[] intArr = new int[]{0, 1, 0, 3, 12};
        new MissingNumberInArray().missingNumber(intArr);
    }
}
