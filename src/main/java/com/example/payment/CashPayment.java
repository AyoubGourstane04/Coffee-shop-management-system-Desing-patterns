package com.example.payment;

public class CashPayment implements PaymentStrategy{
    private Double cashGiven;

    public CashPayment(Double cashGiven){
        this.cashGiven = cashGiven;
    }


    @Override
    public void pay(Double amount) {
        if(cashGiven < amount){
            System.out.println("ERROR: Insufficient cash. $" + String.format("%.2f", cashGiven) +
                    " tendered for a $" + String.format("%.2f", amount) + " bill.");
        }

        double change = cashGiven - amount;
        System.out.println("Paid " + String.format("%.2f", amount) + " dh using Cash.");
        System.out.println("Change returned: " + String.format("%.2f", change) + " dh");
    }
}
