package org.example.dsaquestions;

import java.util.Arrays;

//input = [2,4,7,9,11,15]
//search num = 11, if find true
//note: numbers are in sorting order
public class BinarySearchDemo {

    public boolean searchElement(int [] input,int key, int size){

        int l=0,h= size - 1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(input[mid] > key){
                h = mid-1;
            } else if(input[mid] < key){
                l = mid+1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinarySearchDemo bd = new BinarySearchDemo();
        int [] input = {2,4,7,9,11,15};
        int size = input.length;
        System.out.println(bd.searchElement(input,15,size));
    }
}
