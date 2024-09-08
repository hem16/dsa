package org.example.dp.strategy;

/*
 * -------------------------
    Strategy Design Pattern:
   -------------------------

    So we have different algorithm for diff operation to perform. This DP encapsulates all those algorithm in a class. As per our context
    we can call this class to perform our task.

    Strategy class usually implemented in a inheritance way and we can call any of the implementation hierarchy of the interface based on our use case.

    Role - Client(Context) - uses strategy object to perform an operation.
    Role - Strategy - interface for algorithm implementations
    Role - There are many - Concrete Strategy - implements actual algorithm.
 *
 */
public class StrategyPattern {

    public static void main(String[] args) {
        double amount = 100.0;

        // Using Credit Card Payment Strategy
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe", "123");
        PaymentContext paymentContext = new PaymentContext(creditCardPayment);
        paymentContext.executePayment(amount);

        // Switch to PayPal Payment Strategy
        PaymentStrategy paypalPayment = new PayPalPayment("john.doe@example.com");
        paymentContext.setStrategy(paypalPayment);
        paymentContext.executePayment(amount);

    }

}
