package com.saurabh.practice.leetcode2026.medium.stringANDarray;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {

        int[] answer = new int[nums.length];
        int[] prefixProdArray = new int[nums.length];
        int[] suffixProdArray = new int[nums.length];
        // in two pass
        // lets calculate suffix product and prefix product
        int prefixProd = 1;
        prefixProdArray[0] = 1;
        suffixProdArray[nums.length-1] = 1;
        int suffixProd = 1;
        for(int i = 1; i < nums.length ; i++){
            prefixProd *= nums[i-1];
            prefixProdArray[i] = prefixProd;
        }
        for(int i = nums.length-2; i >=0 ; i--){
            suffixProd *= nums[i+1];
            suffixProdArray[i] = suffixProd;
        }
        for(int i = 0; i < answer.length ; i++){
            answer[i] = prefixProdArray[i] * suffixProdArray[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        new ProductOfArrayExceptSelf().productExceptSelf(new int[]{1,2,3,4});
    }
}
