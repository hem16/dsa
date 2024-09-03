package org.example.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class HIndex {

    public static void main(String[] args) {
        int [] a = {0,1};
        int output = hIndex2(a);
        System.out.println("output = " + output);
    }
    //Solution of complexity of n
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        reverse(citations);  //[6,5,3,1,0] [1,0]
        int len=citations.length;
        for (int i = 0; i < len; i++) { //0
            if (citations[i] >= i + 1) { //1>=1 | 0 >=2
                continue;
            } else {
                return i;
            }
        }
        return len;
    }

    //Solution of complexity of logn - through binary search
    public static int hIndex2(int[] citations) {
        int h = citations.length - 1;
        int l = 0;
        int ans = 0;
        int len = citations.length;
        while(l <=h) {
            int mid = l + (h - l) / 2 ;
            int idx = len - mid;
            if(citations[mid] >= idx) {
                ans = idx;
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }


    private static void reverse(int[] citations) {
        int last = citations.length - 1;
        int mid = citations.length / 2;
        for (int i = 0; i < mid; i++) {
            int temp = citations[i];
            citations[i] = citations[last - i];
            citations[last - i] = temp;
        }
    }
 }
