package org.example.dsaquestions;

import java.util.Arrays;

//input = [1,3,5,5,5,5,67,123,125]
//search num = 5, if find in array and is duplicate then return
//first and last index of element in array.
//note: numbers are in sorting order
//output in this case is 2 & 5
public class BinarySearch3 {
    public int [] getIndexDupInBinarySearch(int [] input, int key, int size) {
        int f=getIndex(input,key,size,true);
        int l=getIndex(input,key,size,false);
        return new int[] {f,l};
    }
    private int getIndex(int [] input, int key, int size,boolean isFirst) {
        int high = size - 1 ; //8
        int low = 0,mid = 0;
        int idx = -1;
        //first element
        while(high >= low) {
            mid = low + (high - low)/2; //{1,3,5,5,5,5,67,123,125}, //4
            if(input[mid] > key) {
                high = mid - 1;
            }else if (input[mid] < key) {
                low = mid + 1;
            } else {
                if(isFirst) {
                    idx = mid;
                    high = mid - 1;
                } else {
                    idx = mid;
                    low = mid + 1;
                }
            }
        }
        return idx;
    }
    public static void main(String[] args) {
        BinarySearch3 binarySearch3 = new BinarySearch3();
        int [] input = {1,3,5,5,5,5,67,123,125};
        int[] answer=binarySearch3.getIndexDupInBinarySearch(input,5,input.length);
        Arrays.stream(answer).forEach(System.out::println);
    }
}
