package org.example.concurrencyconcept;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T {


    public static void main(String[] args) {

        Integer a = 1000, b = 1000;
        System.out.println(a == b);

        Integer c = 100, d = 100;
        System.out.println(c == d);

        List<String> list = Arrays.asList("Modern","Java","In","Action");
        List<Integer> len = list.stream()
                .map(String::length)
                .toList();
        System.out.println(len);

        //
        List<String> list0 = Arrays.asList("Hello","World");
                          List <String> s =list0.stream()
                            .map(w -> w.split(""))
                                    .flatMap(Arrays::stream)
                                  .distinct()
                                            .collect(Collectors.toList());

        System.out.println(s);

    }


}
