package com.example.order;

public class PlaceOrderCommand implements OrderCommand {
    private Order order;
    private OrderStatus prevState;

    public  PlaceOrderCommand(Order order) {
        this.order = order;
    }


    @Override
    public void execute() {
        this.prevState = order.getState();
        System.out.println("[COMMAND] Executing: Place Order #" + order.getOrderId());
        order.nextState();
    }

    @Override
    public void undo() {
        if(prevState != null && prevState != order.getState()){
            System.out.println("[COMMAND] Undoing: Place Order #" + order.getOrderId());
            order.setStatus(prevState);
            System.out.println("Order #" + order.getOrderId() + " reverted to " + prevState.getClass().getSimpleName());
        }

    }
}
