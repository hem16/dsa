package org.example.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Example 1:
 *
 * Input: nums = [3,2,3]
 * Output: 3
 * Example 2:
 *
 * Input: nums = [2,2,1,1,1,2,2]
 * Output: 2
 * approach: the majority element is greater than n/2 then its majority elems in an array.
 */
public class MajorityElement {

    public static void main(String[] args) {
        int [] nums = {2,2,1,1,1,2,2}; //1112222,233
        int num = majorityElement(nums);
        System.out.println("num = " + num);
    }

    public static int majorityElement(int[] nums) {

        Stream<Integer> s = Arrays.stream(nums)
                .boxed()
                .toList()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(k -> k.getValue() > nums.length/2)
                .map(Map.Entry::getKey);
        return s.findFirst().get();
    }

}
