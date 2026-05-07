package com.example.system;

import com.example.order.*;

public class WaiterView implements OrderObserver {
    private String waiterName;

    public WaiterView(String waiterName) {
        this.waiterName = waiterName;
    }


    @Override
    public void update(Order order) {
        if (order.getState() instanceof ReadyState) {
            System.out.println("\n[WAITER NOTIFICATION for " + waiterName + "]");
            System.out.println(">> Ding! Order #" + order.getOrderId() + " is ready for pickup!");
        } else if (order.getState() instanceof CancelledState) {
            System.out.println("\n[WAITER NOTIFICATION for " + waiterName + "]");
            System.out.println(">> Order #" + order.getOrderId() + " was cancelled. Don't serve it.");
        }
    }
}
