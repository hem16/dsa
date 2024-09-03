package org.example.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class RemoveElement {

    /*
     *   ex: Given=Arr: {3,2,2,3}, value to remove=2
     *   Result: {3,3}
     *
     */

    public static void main(String[] args) {
        int nums[] = {3,2,2,3};
        int val = 2;
        int k = removeElement(nums,val);
        System.out.println("k = " + k);

    }

    public static int removeElement(int nums[], int val) {

        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val){
               nums[temp] = nums[i];
               temp++;
            }
        }
        return temp;
    }
}
