package com.example.order;

import com.example.core.MenuComponent;
import com.example.core.StoreManager;

import java.util.ArrayList;
import java.util.List;

//Observer (Subject) & State (Context)
public class Order {
    private static int count = 1;
    private Integer orderId;
    private List<MenuComponent> items;
    private OrderStatus state;
    private List<OrderObserver> observers;

    public Order() {
        this.orderId = count++;
        this.items = new ArrayList<>();
        this.state = new PendingState();
        this.observers = new ArrayList<>();
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void addItem(MenuComponent item){
        items.add(item);
        System.out.println("Added to Order #" + orderId + ": " + item.getName());
    }

    public void removeItem(MenuComponent item){
        if(items.remove(item)){
            System.out.println("Removed from Order #" + orderId + ": " + item.getName());
        }else{
            System.out.println("Component doesn't exist!");
        }
    }

    public Double calculateTotal(){
        double total = 0.0;
        for(MenuComponent menuComponent : items){
            total += menuComponent.getPrice();
        }
        return total;
    }

    public List<MenuComponent> getItems() {
        return items;
    }

   // State Pattern Implementation (The Context)

    public void setStatus(OrderStatus state){
        this.state = state;
        notifyObservers();
    }

    public OrderStatus getState() {
        return this.state;
    }

    public  void nextState(){
        this.state.next(this);
    }

    // Observer Pattern Implementation (The Subject)

    public void addObserver(OrderObserver observer){
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer){
        observers.remove(observer);
    }

    public void notifyObservers() {
        for(OrderObserver observer : observers){
            observer.update(this);
        }
    }


    public void cancelOrder(){
        this.state.cancel(this);
        StoreManager.getInstance().recordVoidedOrder(getOrderId());
    }

}
