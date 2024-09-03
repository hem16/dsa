package org.example.streams;

import java.util.ArrayList;
import java.util.List;

public class Person {
    public enum Sex {
        MALE,FEMALE
    }
    private String name;
    private String age;
    private String emailAddress;
    private Sex gender;


    public Person(String name,String age, String emailAddress,Sex gender){
        this.name=name;
        this.age=age;
        this.emailAddress=emailAddress;
        this.gender=gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Sex getPersonSex() {
        return gender;
    }

    public void setPersonSex(Sex gender) {
        this.gender = gender;
    }
    public void printPerson(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", gender=" + gender +
                '}';
    }

    public static List<Person> getPersonList() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Hemant","30","hem@g.com",Sex.MALE));
        people.add(new Person("Piyush","44","piyush@g.com",Sex.MALE));
        people.add(new Person("Radhika","19","Radhika@g.com",Sex.FEMALE));
        people.add(new Person("Vihan","1","Vihan@g.com",Sex.MALE));
        people.add(new Person("Prayan","7","Prayan@g.com",Sex.MALE));

        return people;
    }
}
