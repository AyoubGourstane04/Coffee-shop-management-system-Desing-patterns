package com.example.order;

//State Pattern
public interface OrderStatus {
    void next(Order order);
    void cancel(Order order);
    void printStatus();
}
