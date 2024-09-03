package org.example.leetcode;

import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        int [] nums = {-1,1,0,-3,3};
        int [] output = productExceptSelf(nums);
        System.out.println("output = " + output);
    }

    private static int[] productExceptSelf(int[] nums) {

        int [] left = new int[nums.length];
        int [] right = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < left.length; i++) {
            left[i] = nums[i-1] * left[i-1];
        }
        int rightLen = nums.length - 1;
        right[rightLen] = 1;
        for (int i = rightLen-1; i >= 0; i--) {
            right[i] = nums[i+1] * right[i+1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = left[i] * right[i];
        }
        return nums;

    }
}
