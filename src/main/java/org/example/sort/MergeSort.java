package org.example.sort;

import java.util.Arrays;


public class MergeSort {

    // WRITE MERGE METHOD HERE //
    public static int[] merge(int[] array1,int[] array2) {
        int [] combined = new int[array1.length + array2.length];
        int idx = 0;
        int i = 0;
        int j = 0;
        while(i < array1.length && j < array2.length) {

            if(array1[i] < array2[j]) {
                combined[idx] = array1[i];
                idx++;
                i++;
            } else {
                combined[idx] = array2[j];
                idx++;
                j++;
            }
        }

        while(i < array1.length) {
            combined[idx] = array1[i];
            idx++;
            i++;
        }

        while(j < array2.length) {
            combined[idx] = array2[j];
            idx++;
            j++;
        }

        return combined;

    }

    public static void main(String[] args) {

        //int[] array1 = {1,3,7,8};
        //int[] array2 = {2,4,5,6};

        //System.out.println( Arrays.toString( merge(array1, array2) ) );

        int [] originalArr = {3,4,2,1};
        int [] sortedArr = mergeOriginalSort(originalArr);

        System.out.println("Orginal sort=>"+Arrays.toString( originalArr) );

        System.out.println("After Sort=>"+Arrays.toString( sortedArr ) );
    }

    private static int[] mergeOriginalSort(int[] originalArr) {
        int len = originalArr.length;
        if(len == 1) {
            return originalArr;
        }
        int mid = len / 2;
        int[] left = mergeOriginalSort(Arrays.copyOfRange(originalArr, 0, mid));
        int[] right = mergeOriginalSort(Arrays.copyOfRange(originalArr, mid, len));
        return merge(left,right);
    }

}


