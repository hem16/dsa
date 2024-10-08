package org.example.dp.strategy;

// PayPalPayment.java
public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal payment of " + amount + " for " + email + ".");
    }
}
