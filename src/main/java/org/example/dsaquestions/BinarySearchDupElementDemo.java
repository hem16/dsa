package org.example.dsaquestions;

import java.text.NumberFormat;
import java.util.Arrays;

//input = [1,3,5,5,5,5,67,123,125]
//search num = 5, if find in array and is duplicate then return
//first and last index of element in array.
//note: numbers are in sorting order
//output in this case is 2 & 5
public class BinarySearchDupElementDemo {
    //itr-1 | lw=0,hg=8,mid=4,i[mid]=5,f=4,hg=3
    //itr-2 | lw=0,hg=3,mid=1,i[mid]=3,lw=2,hg=3
    //itr-3 | lw=2,hg=3,mid=2,i[mid]=5,f=2,hg=1 --> after condition failed and we get f=2
    public int[] getFirstLastIndexElement(int [] input,int key,int size) {
        int lw=0,hg=size -1;
        int f = -1,l = -1;
        //first element
        while(lw<=hg) {
            int mid = lw + (hg-lw)/2;
            if(input[mid] > key){
                hg = mid - 1;
           } else if(input[mid] < key) {
                lw = mid + 1;
           } else {
                f = mid;
                hg = mid - 1;
           }
        }
        lw = 0;
        hg = size -1;
        //last element
        while(lw<=hg) {
            int mid = lw + (hg-lw)/2;
            if(input[mid] > key){
                hg = mid - 1;
            } else if(input[mid] < key) {
                lw = mid + 1;
            } else {
                l = mid;
                lw = mid + 1;
            }
        }
        return new int[]{f, l};
    }

    public static void main(String[] args) {
        NumberFormat numberFormat;
        BinarySearchDupElementDemo bd = new BinarySearchDupElementDemo();
        int [] input = {1,3,5,5,5,5,67,123,125};
        int size = input.length;
        Arrays.stream(bd.getFirstLastIndexElement(input,5,size)).forEach(System.out::println);
    }

    Object obj = new Object();

}
