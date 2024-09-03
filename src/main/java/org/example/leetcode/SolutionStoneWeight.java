package org.example.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

class SolutionStoneWeight {

    public static void main(String[] args) {
        int [] stones = {2,7,4,1,8,1};
        int lastStoneWeight = lastStoneWeight(stones);
        System.out.println("lastStoneWeight = " + lastStoneWeight);
    }

    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=stones.length-1;i>=0;i--){
            q.add(stones[i]);
        }
        while(q.size()>1){
            int y=q.poll();
            int x = q.poll();
            q.add(y-x);
        }
        return q.poll();

    }
}
