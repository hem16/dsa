package org.example.leetcode;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * nums = [1,2,3,4,5,6,7], k =3 | ...1,2,3,4 =>
 * Output: [5,6,7,1,2,3,4] | 7,6,5,4,3,2,1 =>
*/
public class RotateArray {

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotateNums(nums,k);

        System.out.println("reverseNums = " + nums);
    }

    private static void rotateNums(int[] nums,int k) {
        k = k % nums.length;
        reverseArr(nums,0, nums.length-1);
        reverseArr(nums,0,k-1);
        reverseArr(nums,k,nums.length-1);

    }

    private static void reverseArr(int[] nums,int left,int right) {
       while(left<right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
       }
        System.out.println("nums = " + nums);
    }


}
