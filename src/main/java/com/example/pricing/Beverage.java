package com.example.pricing;

import com.example.core.MenuComponent;

//Decorator
public abstract class Beverage implements MenuComponent {
    protected String description = "Unknown Beverage";


    public String getDescription(){
        return this.description;
    }

    public abstract Double cost();


    @Override
    public String getName(){
        return getDescription();
    }

    @Override
    public Double getPrice(){
        return cost();
    }

    @Override
    public void print(){
        System.out.println(getName() + " : " + getPrice() + " dh.");
    }


}
