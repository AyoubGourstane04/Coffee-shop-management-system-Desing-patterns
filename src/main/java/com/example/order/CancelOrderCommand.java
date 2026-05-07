package com.example.order;

import com.example.core.MenuComponent;

import java.util.ArrayList;
import java.util.List;

public class CancelOrderCommand implements OrderCommand {
    private Order order;
    private List<MenuComponent> backupitems;
    private OrderStatus prevState;

    public CancelOrderCommand(Order order) {
        this.order = order;
    }

    @Override
    public void execute() {
        this.prevState = this.order.getState();
        this.backupitems = new ArrayList<>(this.order.getItems());

        System.out.println("[COMMAND] Executing: Cancel Order #" + order.getOrderId());
        this.order.cancelOrder();
    }

    @Override
    public void undo() {
        if(this.prevState != null && prevState != order.getState()){
            System.out.println("[COMMAND] Undoing: Cancel Order #" + order.getOrderId());
            for(MenuComponent item : this.backupitems){
                this.order.addItem(item);
            }

            order.setStatus(this.prevState);
            System.out.println("Order #" + order.getOrderId() + " has been restored.");
        }
    }
}
