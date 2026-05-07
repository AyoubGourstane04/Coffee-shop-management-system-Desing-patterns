package com.example.pricing;

//Decorator (Concrete Decorator)
public class MilkDecorator extends AddonDecorator{

    public MilkDecorator(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public Double cost() {
        return beverage.cost() + 0.50;
    }
}
