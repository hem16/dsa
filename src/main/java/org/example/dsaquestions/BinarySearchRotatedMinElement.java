package org.example.dsaquestions;

//Minimum number in Sorted Rotated Array
//example:
//n=[5,6,7,8,9,10,1,2,3,4],answer = 1
//n=[1,2,3,4,5,6,7,8,9,10],answer = 1 //
public class BinarySearchRotatedMinElement {
    public int getMinElement(int n[],int size) {
        int l = 0; //0 | 5 | 6
        int h = size - 1; // 9 | 6
        int mid = 0;
        while (l <= h) { // 0<=9 | 5<= 9 | 5<=6 | 6<=6
            mid = l + (h - l) / 2; // 4 | 7 | 5 | 6
            if (mid == 0 || n[mid-1] > n[mid]) // 8 > 9 | 1 > 2 | 9 > 10 | 10 > 1
                return n[mid]; // 1
            if (n[l] > n[mid]) { // 5>9 | 10>2 | 10>10
                h = mid - 1; // 6
            } else if (n[mid] > n[h]) { //9>4 | 10>1
                l = mid + 1; // 5 | 6
            } else {
                return n[l];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchRotatedMinElement minElement = new BinarySearchRotatedMinElement();
        int [] n = {3,2};
        int minE = minElement.getMinElement(n,n.length);
        System.out.println("minE = " + minE);
    }
}
