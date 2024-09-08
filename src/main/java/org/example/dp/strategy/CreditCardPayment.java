package org.example.dp.strategy;

public class CreditCardPayment implements PaymentStrategy{
    private String cardNumber;
    private String cardHolder;
    private String cvv;

    public CreditCardPayment(String cardNumber, String cardHolder, String cvv) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing credit card payment of " + amount + " for " + cardHolder + ".");
    }
}
