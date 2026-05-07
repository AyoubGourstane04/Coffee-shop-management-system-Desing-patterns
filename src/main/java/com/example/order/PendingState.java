package com.example.order;

public class PendingState implements OrderStatus{

    @Override
    public void next(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is now being prepared.");
        order.setStatus(new PreparingState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order #" + order.getOrderId() + " has been cancelled.");
        order.getItems().clear();
        order.setStatus(new CancelledState());
    }

    @Override
    public void printStatus() {
        System.out.println("Status: PENDING (Waiting for kitchen)");
    }
}
