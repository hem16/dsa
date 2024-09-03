package org.example.leetcode;

/**
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 */
public class JumpGame {

    public static void main(String[] args) {
        int [] nums = {3,2,1,0,4};
        Boolean flag = canJump(nums);
        System.out.println("flag = " + flag);
    }

    private static Boolean canJump(int[] nums) {
        int max = 0;
        int n = nums.length;
        if(n==1) return true;
        for (int i = 0; i < n-1 && max >=i; i++) {
            if(max < i + nums[i]) {
                max = i + nums[i];
            }
            if(max >=n-1){
                return true;
            }
        }
        return Boolean.FALSE;
    }
}
