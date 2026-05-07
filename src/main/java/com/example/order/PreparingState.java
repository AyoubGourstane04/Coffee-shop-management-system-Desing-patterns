package com.example.order;

public class PreparingState implements OrderStatus{

    @Override
    public void next(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is now ready.");
        order.setStatus(new ReadyState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("CANNOT CANCEL : Order #" + order.getOrderId() + " is already in the machine!");
    }

    @Override
    public void printStatus() {
        System.out.println("Status: PREPARING (In progress)");
    }
}
