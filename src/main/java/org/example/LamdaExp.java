package org.example;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.IntToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LamdaExp {

    public static void main(String args[]) {

        List<String> list = Arrays.asList("bob,carly,neals,param,amit");
        System.out.println("Before sort..."+list);
        Collections.sort(list,(o1,o2) -> o1.compareTo(o2));
        System.out.println("after sort..."+list);

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();
        list1.add("sachin");
        list1.add("saurabh");
        list1.add("kaif");

        ListIterator s = list1.listIterator();
        while(s.hasNext()){
            if(s.next().equals("kaif"))
                list1.add("piyush");

        }

        for (String s1:
             list1) {
            System.out.println("s1 = " + s1);
        }

    }

}
