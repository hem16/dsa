package org.example.streams;

import java.util.*;
import java.util.stream.Collectors;

public class FilterStreamDemo {
    public static void main(String[] args) {

        MobileNumber mobileNumber0 = new MobileNumber("1233");
        MobileNumber mobileNumber1 = new MobileNumber("1234");
        MobileNumber mobileNumber2 = new MobileNumber("3333");

        List mobileList0 = new ArrayList<>();
        mobileList0.add(mobileNumber0);
        mobileList0.add(mobileNumber1);

        List mobileList1 = new ArrayList<>();
        mobileList1.add(mobileNumber1);
        mobileList1.add(mobileNumber2);

        Address address0 = new Address("4620003");
        Address address1 = new Address("1235");

        Student student0 = new Student("hemant",40,address0, mobileList0);
        Student student1 = new Student("ashu",36,address1, mobileList0);
        Student student2 = new Student("omi",20,address0, mobileList1);
        Student student3 = new Student("jayesh",20,address0, mobileList1);

        List<Student> student = new ArrayList<>();
        student.add(student0);
        student.add(student1);
        student.add(student2);
        student.add(student3);

        //Get student with exact match name "jayesh"
        Optional<Student> specificSt = student.stream()
                .filter(st -> st.getName().equalsIgnoreCase("jayesh"))
                .findFirst();
        System.out.println(specificSt.isPresent() ? specificSt.get().getName() : "No student found");

        //Get student with matching address "1235"
        /*Optional<Student> optSt = student.stream()
                .filter(st -> st.getAddress().getZipcode().equalsIgnoreCase("1235"))
                        .findFirst();
        System.out.println(optSt.isPresent() ? optSt.get().getName() +",address :"+ optSt.get().getAddress().getZipcode() : "No student found");*/

        //Get all student having mobile numbers 3333.
        List<Student> students=student.stream()
                .filter(st -> st.getMobileNumbers().stream()
                        .anyMatch(m -> m.getNumber() == "3333"))
                .collect(Collectors.toList());
        String name=students.stream()
                .map(st -> st.getName())
                .collect(Collectors
                        .joining(",","[","]"));
        System.out.println(name);

        //Get all student having mobile number 1233 and 1234
        List<Student> studentList=student.stream()
                .filter(st -> st.getMobileNumbers()
                        .stream().allMatch(m -> m.getNumber().equals("1233") || m.getNumber().equals("1234")))
                .toList();

        String stud = studentList.stream().map(s -> s.getName()).collect(Collectors.joining(",","[","]"));
        System.out.println("skkjd "+stud);

        //Create a List<Student> from the List<TempStudent>
        List<TempStudent> tst =student.stream()
                .map(st -> new TempStudent(st.getName(),st.getAge(),st.getAddress(),st.getMobileNumbers()))
                .toList();
        tst.forEach(t -> System.out.println("name::" + t.name +" age::"+t.age));

        //Convert List<Student> to List<String> of student name
        List<Student> names =student.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println("s-> "+names);

        //Convert List<students> to String
        String studNames = student.stream()
                .map(Student::getName).collect(Collectors.joining(","));
    }
}
