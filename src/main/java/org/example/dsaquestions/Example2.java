package org.example.dsaquestions;

import java.util.Stack;

/*
    Valid Parentheses
    In a given string s, s is valid only if -
    - Open bracket must be closed by same type of brackets.
    - Open bracket must be closed in correct order
    - Every Close bracket has a corresponding open bracket of same type.
 */
public class Example2 {

    public boolean isValidString(String s) {
        char [] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Character check = null;
        for (char ch : charArray){
            switch (ch) {
                case '(':
                    stack.push(ch);
                break;
                case '{':
                    stack.push(ch);
                break;
                case '[':
                    stack.push(ch);
                break;
                case ')':
                    check = stack.pop();
                    if(check == '{' || check == '[')
                        return false;
                    break;
                case '}':
                    check= stack.pop();
                    if(check == '(' || check == '[')
                        return false;
                    break;
                case ']':
                    check=stack.pop();
                    if(check == '(' || check == '{')
                        return false;
                    break;
                default:
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        Example2 ex = new Example2();
        String validity = ex.isValidString(  ")([{}])") ? "Valid" : "InValid";
        System.out.println("The given String is "+validity);
    }

}
