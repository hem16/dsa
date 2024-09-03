package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLambdaDemo {

    public static List<Person> printPersonOlderThan(List<Person> persons, int age) {
        List olderPerson=persons.stream()
                .filter(person -> Integer.parseInt(person.getAge()) > age)
                .collect(Collectors.toList());
        return olderPerson;
    }

    public static List<Person> printRangePersonWithAge(List<Person> persons,int lAge,int hAge){
        List<Person> rangePersonAge = persons.stream()
                .filter(person -> Integer.parseInt(person.getAge()) > lAge && Integer.parseInt(person.getAge()) < hAge)
                .collect(Collectors.toList());
        return rangePersonAge;
    }

    public static void main(String[] args) {
        StreamLambdaDemo lambdaDemo = new StreamLambdaDemo();
        System.out.println(lambdaDemo.printPersonOlderThan(Person.getPersonList(),30));
        System.out.println(lambdaDemo.printRangePersonWithAge(Person.getPersonList(),5,30));

        Map<Integer,Person> personMap = new HashMap<>();
        personMap.put(40,new Person("Hemant","40","xyz@g.com", Person.Sex.MALE));
        personMap.put(38,new Person("Hem","38","lmn@g.com", Person.Sex.MALE));
        personMap.put(42,new Person("He","42","lmn1@g.com", Person.Sex.MALE));
        personMap.put(45,new Person("Hema","45","lmn2@g.com", Person.Sex.FEMALE));
        personMap.put(41,new Person("Hea","41","lmn2@g.com", Person.Sex.FEMALE));

        personMap.forEach((k,v) -> System.out.println(v.getName() +":"+v.getAge()));
        // OR
        personMap
                .entrySet()
                .stream()
                .forEach(e -> System.out.println("Name = " + e.getValue().getName() +":" + e.getValue().getAge() ));

        TreeMap<Integer,Person> map = new TreeMap<>();
        map.put(40,new Person("Hemant","40","xyz@g.com", Person.Sex.MALE));
        map.put(38,new Person("Hem","38","lmn@g.com", Person.Sex.MALE));
        map.put(42,new Person("He","42","lmn1@g.com", Person.Sex.MALE));
        map.put(45,new Person("Hema","45","lmn2@g.com", Person.Sex.FEMALE));
        map.put(41,new Person("Hea","41","lmn2@g.com", Person.Sex.FEMALE));

        map.tailMap(40).entrySet()
                .stream().forEach(e -> System.out.println("Name = " + e.getValue().getName() +":" + e.getValue().getAge() ));

        int[] nums = {0,1,0,1,0,1,0,1,0,1,0}; // => 00001111
        int numlen = nums.length;
        int[] temp = new int[numlen];
        Arrays.fill(temp,0);
        int j=numlen;
        for(int i=numlen-1;i>=0;i--){
            if(nums[i] == 1) {
                temp[--j] = 1;
            }
        }
        for (int i=0;i< temp.length;i++){
            System.out.println("temp[i] = " + temp[i]);
        }
            
    }
}
