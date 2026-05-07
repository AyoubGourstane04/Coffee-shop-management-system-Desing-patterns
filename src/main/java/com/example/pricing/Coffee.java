package com.example.pricing;

//Decorator (Concrete Component)
public class Coffee extends Beverage{

    public Coffee(){
        description = "Plain Coffee";
    }

    @Override
    public Double cost() {
        return 2.00;
    }
}
