package org.example.generics;

import java.util.*;

public class GenericsDemo {

    public static void main(String[] args) {
        //GenericType<Integer> genInt = new GenericType<>(20);
        //genInt.printIt();

        GenericType<Double> genDouble = new GenericType<>(20.0);
        genDouble.printIt();

        Map map = new TreeMap();
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        q.offer(5);
        q.offer(7);
        System.out.println(q.pop());
        //map.put("k", List.of("hem","ash","gat"));
        //map.put("z",List.of("yog","son","prayan","vihan"));
        //map.put("a",List.of("deep","ranu"));
        System.out.println(map);
    }
}
