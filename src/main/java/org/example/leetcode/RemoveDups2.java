package org.example.leetcode;

/*
 *  Input: nums = [1,1,1,2,2,3]
 *  Output: 5, nums = [1,1,2,2,3,_]
 */
public class RemoveDups2 {
    public static void main(String[] args) {
        int [] nums = {0,0,1,1,1,1,2,3,3};
        int k = removeDuplicates(nums);
        System.out.println("k = " + k);
    }

    private static int removeDuplicates(int[] nums) {
    int temp=0;
    for(int i=0;i<nums.length;i++) {
        if(i<nums.length-2 && nums[i]==nums[i+2]) { //i=0 && 0 == 1 | i=1 && 0 == 1 | i=4 && 1==2,i=5 && 1==3

            continue;
        }
        nums[temp]=nums[i]; //nums[0]=0,nums[1]=0,nums[2]=1,nums[3]=1,nums[4]=2,nums[5]=3,nums[6]=3
            temp++;
    }
        return temp;
    }
}
