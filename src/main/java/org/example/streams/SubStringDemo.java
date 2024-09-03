package org.example.streams;

public class SubStringDemo {
    public static void main(String[] args) {
        String str = "abcdabceabcfabch";
        String findString = "abc";
        int lastIndex = 0;
        int count = 0;
        while(lastIndex !=-1){
            lastIndex = str.indexOf(findString,lastIndex);
            if(lastIndex != -1){
                count++;
                lastIndex += findString.length();
            }
        }
        System.out.println("count = " + count);
    }
}
