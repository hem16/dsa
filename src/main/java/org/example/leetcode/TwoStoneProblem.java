package org.example.leetcode;

import java.util.Arrays;

public class TwoStoneProblem {

    /**
     * return last stone weight
     * input stone = [2,7,4,1,8,1]
     * output = 1
     */

    public static void main(String[] args) {
        int [] stones = {1};
        int lastStoneWeight = lastStoneWeight(stones);
        System.out.println("lastStoneWeight = " + lastStoneWeight);
    }

    private static int lastStoneWeight(int[] stones) {
        int i = stones.length;
        int empty [] = {};
        while (i != 1 && i > 0 ) {
            Arrays.sort(stones);
            System.out.println("stones = " + Arrays.toString(stones));
            int y = stones.length - 1;
            int x = y - 1;
            if (stones[x] != stones[y]) {
                int temp = stones[x];
                stones[y] = stones[y] - stones[x];
                stones[x] = stones[y] ;
                stones = Arrays.copyOfRange(stones, 0, y);
            } else {
                stones = Arrays.copyOfRange(stones, 0, y - 1);
            }
            i =  stones.length;
         }
        return i == 0 ? empty.length : stones[0];
    }

}
