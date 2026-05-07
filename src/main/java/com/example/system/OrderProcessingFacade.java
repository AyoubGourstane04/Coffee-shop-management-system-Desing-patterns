package com.example.system;

import com.example.core.StoreManager;
import com.example.order.Order;
import com.example.order.ReadyState;
import com.example.payment.PaymentStrategy;

//Facade Pattern
public class OrderProcessingFacade {

    public void processCheckout(Order order, PaymentStrategy paymentStrategy) {
        System.out.println("\n=== INITIATING CHECKOUT FOR ORDER #" + order.getOrderId() + " ===");

        if(!(order.getState() instanceof ReadyState)){
            System.out.println("ERROR: Cannot checkout. Order is currently in state: "
                    + order.getState().getClass().getSimpleName());
            return;
        }

        Double total = order.calculateTotal();

        if(total <= 0.0){
            System.out.println("ERROR: Cannot checkout an empty or fully discounted order.");
            return;
        }

        System.out.println("Total Amount Due: " + String.format("%.2f", total) + " dh");
        paymentStrategy.pay(total);

        order.nextState();

        StoreManager.getInstance().recodSale(total);
        System.out.println("=== CHECKOUT SUCCESSFUL ===");

    }

}

