package org.example.dsaquestions;

import java.time.Instant;
import java.time.InstantSource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    A Valid Palindrom
    Condition : Remove all alphanumeric characters in a given string.
                All uppercase should convert to lower case.
    Example:-Input: s = "A man, a plan, a canal: Panama"
             Output: true
             Explanation: "amanaplanacanalpanama" is a palindrome.
            -Input: s = "race a car"
             Output: false
             Explanation: "raceacar" is not a palindrome.
            -Input: s = " "
             Output: true
             Explanation: s is an empty string "" after removing non-alphanumeric characters.
             Since an empty string reads the same forward and backward, it is a palindrome.
 */
public class Example5 {

    public boolean isValidPalindrom(String str) {
        String finalStr = removeSpaceAlphanumeric(str);
        //str = str.replaceAll("[^a-zA-Z0-9]", "");
        boolean isPalindrom = false;
        if(finalStr.isEmpty()) // if String s is empty return true
            return true;
        String forwardStr = finalStr;
        String revStr = new StringBuilder(forwardStr).reverse().toString();

        System.out.println(forwardStr);
        System.out.println(revStr);

        if(forwardStr.equals(revStr)){
            isPalindrom = true;
        } else {
            isPalindrom = false;
        }
        return isPalindrom;
    }

    public String removeSpaceAlphanumeric(String str) {
        char[] chStr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chStr) {
            if (ch >= 65 && ch <= 90) {
                sb.append(ch);
            }
            if (ch >= 97 && ch <= 122) {
                sb.append(ch);
            }
            if (ch >= 48 && ch <= 57) {
                sb.append(ch);
            }
        }

        return sb.toString().toLowerCase();
    }

    public static void main(String[] args) {
        Example5 ex = new Example5();
        System.out.println("String is "+((ex.isValidPalindrom(" ")) ? "Palindrom" : "Not Palindrom" ));
        Instant i =InstantSource.system().instant();
        System.out.println("i = " + i);
        LocalDate d =LocalDate.now();
        System.out.println("d = " + d);
        List l = Arrays.asList(1,4,2,5,5);

    }
}
