package com.example.system;

import com.example.core.MenuComponent;
import com.example.order.Order;
import com.example.order.OrderObserver;
import com.example.order.PreparingState;

public class KitchenMonitor implements OrderObserver {
    private String monitorId;

    public KitchenMonitor(String monitorId) {
        this.monitorId = monitorId;
    }


    @Override
    public void update(Order order) {
        if(order.getState() instanceof PreparingState){
            System.out.println("\n[KITCHEN MONITOR " + monitorId + "]");
            System.out.println(">>> NEW ITEMS TO COOK (Order #" + order.getOrderId() + "):");
            for(MenuComponent item : order.getItems()){
                System.out.println("  - " + item.getName());
            }
        }
    }
}
