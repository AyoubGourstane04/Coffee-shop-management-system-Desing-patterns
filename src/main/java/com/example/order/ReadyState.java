package com.example.order;

public class ReadyState implements OrderStatus{

    @Override
    public void next(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is already finished. No further steps.");    }

    @Override
    public void cancel(Order order) {
        System.out.println("CANNOT CANCEL : Order #" + order.getOrderId() + " is already done!");
    }

    @Override
    public void printStatus() {
        System.out.println("Status: READY (Waiting for pickup)");
    }
}
