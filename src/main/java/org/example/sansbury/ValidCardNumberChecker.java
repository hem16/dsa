package org.example.sansbury;

public class ValidCardNumberChecker {

    public static boolean isValidCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        for(int i = cardNumber.length() - 1; i>= 0; i--){
            int digit = Character.getNumericValue(cardNumber.charAt(i));
            if(alternate) {
                digit *= 2;
                if (digit > 9) {
                    digit = (digit % 10) + (digit / 10);
                }
            }
            sum += digit;
            alternate = ! alternate;
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        String cardNumber = "379354508162306";//"4532756279624064"; //379354508162306
        if(isValidCardNumber(cardNumber)) {
            System.out.println("Valid CardNumber");
        } else {
            System.out.println("InValid CardNumber");
        }
    }
}
