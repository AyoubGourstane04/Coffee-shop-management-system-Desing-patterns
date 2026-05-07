package com.example.payment;

public class CreditCardPayment implements PaymentStrategy {
    private String nameOnCard;
    private String cardNumber;

    public CreditCardPayment(String nameOnCard, String cardNumber) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(Double amount) {
        String maskedCard = "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);

        System.out.println("Processing credit card for " + nameOnCard + "...");
        System.out.println("Paid " + String.format("%.2f", amount) + " dh using Credit Card (" + maskedCard + ").");
    }

}
