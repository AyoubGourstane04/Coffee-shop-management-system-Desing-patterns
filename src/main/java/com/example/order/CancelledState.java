package com.example.order;

public class CancelledState implements OrderStatus {
    @Override
    public void next(Order order) {
        System.out.println("LOGIC ERROR: Cannot process Order #" + order.getOrderId() +
                " because it has been cancelled.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("Order #" + order.getOrderId() + " is already cancelled.");
    }

    @Override
    public void printStatus() {
        System.out.println("Status: CANCELLED (This order is void)");
    }
}
