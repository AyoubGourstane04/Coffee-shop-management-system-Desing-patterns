package com.example.order;

//Command Pattern
public interface OrderCommand {
    void execute();
    void undo();
}
