package org.example.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Median {
    public static void main(String args[]){
        List<Integer> num=Arrays.asList(5,8,1,4,2,8);
        boolean bool = (long) num.size() % 2 == 0;
        List<Integer> numArray=num.stream()
                .sorted().toList();
        int mid = numArray.size()/2;
        float median = 0;
        if(bool){
            median = (float) (numArray.get(mid) + numArray.get(mid + 1)) / 2;
        } else {
            median = numArray.get(mid);
        }
        System.out.println(median);
    }
}
