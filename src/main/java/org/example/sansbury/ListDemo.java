package org.example.sansbury;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListDemo {

    public static void main(String[] args) {

        final int i1 = 1;
        final Integer i2 = 1;
        final String s1 = ":ONE";
        String str1 = i1 + s1;
        String str2 = i2 + s1;
        System.out.println(str1.hashCode());
        System.out.println("1:ONE".hashCode());
        System.out.println(str1 == "1:ONE");

        System.out.println(str2.hashCode());
        System.out.println("1:ONE".hashCode());
        System.out.println(str2 == "1:ONE");

    }

    }


