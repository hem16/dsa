package org.example.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        int k = removeDuplicate(nums);
        System.out.println("k = " + k);

    }

    private static int removeDuplicate(int[] nums) {

        int temp = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[temp] != nums[i]) { //0,0|0,1|1,1|1,1|1,2|2,2|2,3|3,3|3,4
                temp ++; //temp=2,temp=3,temp=4
                nums[temp] = nums[i];
            }
        }
        return Arrays.copyOf(nums,temp+1).length;
    }
}
