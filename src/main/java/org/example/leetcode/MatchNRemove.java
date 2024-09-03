package org.example.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatchNRemove {

    public static void main(String[] args) {
        List<String> to_remove = Arrays.asList("%","-","&",":");
        List<String> remove_from = Arrays.asList("AB%","CDE","MN&","CH:H","DSA","JAVA-HOME");
        List<String> ans = matchNRemoveFromList(to_remove,remove_from);
        ans.forEach(s -> System.out.println("s = " + s));
    }

    private static List<String> matchNRemoveFromList(List<String> toRemove, List<String> removeFrom) {

        return removeFrom.stream()
                .filter(s -> toRemove.stream().noneMatch(s::contains))
                .collect(Collectors.toList());
    }

}
