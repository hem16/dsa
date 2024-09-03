package org.example.dsaquestions;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping {

        public static void main(String[] args) {

            //3 apple, 2 banana, others 1
            List<String> items =
                    Arrays.asList("apple", "apple", "banana",
                            "apple", "orange", "banana", "papaya");

            Map<String, List<String>> result =
                    items.stream().collect(
                            Collectors.groupingBy(
                                    Function.identity()
                            )
                    );
            System.out.println("b4=>"+result);
            result.get("apple").replaceAll( e -> "green apple");
            System.out.println("after="+result);


        }
    }

