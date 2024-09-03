package org.example.dsaquestions;

import java.util.*;

/*
    Two-Sum
    Given an array of integer nums and an integer target, return indices of the
    two numbers such that they add up to target.#
    ex: nums = [2,7,11,15], target = 9
    output should be [0,1]
 */
public class Example1 {

    // complexity - o[n^2]
    public List targetSum(int[] a, int target){
        List outList = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length ; j++) {
                if ((a[i] + a[j]) == target) {
                    outList.add(++i);
                    outList.add(++j);
                    return outList;
                }
            }
        }
        return outList;
    }

    // same problem with improved time complexity - o[n]
    public int[] sumTarget(int [] a, int target){
        int [] arrRes = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if(map.containsKey(target - a[i])) { //2,15,11,7
                arrRes[0] = map.get(target - a[i]);
                arrRes[1] = i;
            }
            map.put(a[i],i); //[2,0][15,1][11,2][7,3]
        }
        return arrRes;
    }

    public static void main(String[] args) {
        Example1 ex = new Example1();
        int [] a = {2,15,12,7};
        int target = 9;
        //ex.targetSum(a,target)
          //      .forEach(res -> System.out.println(res));
        Arrays.stream(ex.sumTarget(a,target)).forEach(res -> System.out.println(res));


    }
}
