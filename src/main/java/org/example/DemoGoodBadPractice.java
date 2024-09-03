package org.example;

import java.io.*;
import java.util.*;

public class DemoGoodBadPractice {

    public static void main(String[] args) {

    }

    public void setDrivers() {
        User user = new User();
        List<String> drivers = new LinkedList<String>();
        List<String> nonDrivers = new LinkedList<String>();

        boolean userFlag = user.getAge() >= 18 ? drivers.add(user.getFirstName()) : nonDrivers.add(user.getFirstName());
    }

    public int expensiveFunctionExample() {
        int currNum = 0;
        if (getExpensiveOperationResult() > currNum)
            currNum = getExpensiveOperationResult();
        for (int i=0; i < getExpensiveOperationResult(); ++i)
            System.out.println(getExpensiveOperationResult());

        return currNum;
    }

    public int getExpensiveOperationResult() {
        int number = 100000;
        //some expensive compute operation
        return number;
    }

    public void stringExample() {
        String oneMillionHello = "";
        for (int i = 0; i < 1000000; i++) {
            oneMillionHello = oneMillionHello + "Hello!";
        }
        System.out.println(oneMillionHello.substring(0, 6));

    }

    public String buildUserQuery() {
        User user = new User();
        String sql = "Insert Into Users (name, email, pass, address)";
        sql += " values ('" + user.getFirstName();
        sql += "', '" + user.getLastName();
        sql += "', '" + user.getEmail();
        sql += "', '" + user.getAddress();
        sql += "')";

        return sql;
    }

    public void closeResourcesExample () {
        FileInputStream inputStream = null;
        try {
            File file = new File("./tmp.txt");
            inputStream = new FileInputStream(file);

        } catch (FileNotFoundException e) {
            System.out.println("File not found..");
        } finally {
            //do nothing
        }
    }

    private List<Integer> getIndexArray(String[] StringArray, String value){
        List<Integer> list = new LinkedList<Integer>();
        int index = 0;
        for (String i : StringArray){
            if (i.equals(value)){
                list.add(index);
            }
            index += 1;
        }
        return list;
    }

}
