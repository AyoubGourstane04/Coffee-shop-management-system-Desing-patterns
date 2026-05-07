package com.example.menu;

import com.example.core.MenuComponent;

// composite (leaf)
public class MenuItem implements MenuComponent{
    public String name;
    public Double price;

    public MenuItem(String name, Double price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public Double getPrice(){
        return this.price;
    }

    @Override
    public void print(){
        System.out.println(getName() + " : " + getPrice() + " dh.");
    }

}
