package com.example.pricing;

//Decorator (Concrete Decorator)
public class SugarDecorator extends AddonDecorator{

    public SugarDecorator(Beverage beverage){
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public Double cost() {
        return beverage.cost() + 0.20;
    }
}
