package org.example.dsaquestions;

//Minimum number in Sorted Rotated Array
//example:
//n=[11,22,55,88,108,99,33],answer = 108
public class BinarySearchPeakElement {

    public int getBitonicElement(int [] n, int size) {
        int l=0; //0 | 2 | 3
        int h=size-1; // 8 | 3
        int mid=0; //
        while(l<=h) { // 0<=8 | 2<=3
            mid = l + (h-l) / 2; // 4 | 1 | 2
            if(mid == 0 || n[mid-1] < n[mid] && n[mid] > n[mid+1]) {
                return n[mid]; //
            }
            if(n[mid-1] > n[mid]) { //45>42 | 1>15 | 1>25
                h = mid - 1; // 3
            } else if(n[mid] < n[mid+1]) { // 15<25 | 25<45
                l = mid + 1; // 2 | 3
            } else {
                return n[l];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchPeakElement peakElement = new BinarySearchPeakElement();
        int [] n={1,15,25,45,42,21,17,12,11};
        int peak = peakElement.getBitonicElement(n,n.length);
        System.out.println("peak = " + peak);
    }
}
