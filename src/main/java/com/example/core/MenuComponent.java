package com.example.core;

// composite 
public interface MenuComponent {

    default String getName(){
        throw new UnsupportedOperationException("This component does not support getName().");
    }

    default Double getPrice(){
        throw new UnsupportedOperationException("This component does not support getPrice().");
    }

    default void print(){
        throw new UnsupportedOperationException("This component does not support print().");
    }

    default void add(MenuComponent component){
        throw new UnsupportedOperationException("This component does not support adding items.");
    }

    default void remove(MenuComponent component){
        throw new UnsupportedOperationException("This component does not support removing items.");
    }
}
