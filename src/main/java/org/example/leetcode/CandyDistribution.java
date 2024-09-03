package org.example.leetcode;

import java.util.Arrays;

public class CandyDistribution {

    public static void main(String[] args) {
        int [] ratings = {1,0,2};
        int numOfCandy=candy(ratings);
        System.out.println("numOfCandy = " + numOfCandy);
    }

    private static int candy(int[] ratings) {
        int [] ans = new int[ratings.length];

        Arrays.fill(ans, 1);
        int leftLen =  ans.length - 1;
        for (int i = 0; i <= leftLen - 1; i++) {
            if(ratings[i] < ratings[i+1]) {
                ans[i+1] = ans[i] + 1;
            }
        }
        int rightLen =  ans.length - 1;
        for (int i = rightLen; i > 0; i--) {
            if(ratings[i] < ratings[i-1] && ans[i] >= ans[i-1]) {
                ans[i-1] = ans[i] + 1;
            }
        }
        int candy = 0;
        for (int i: ans) {
            candy+=i;
        }

        return candy;
    }
}
