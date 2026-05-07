package com.example.pricing;

//Decorator
public abstract class AddonDecorator extends Beverage{
    protected  Beverage beverage;

    public AddonDecorator(Beverage beverage){
        this.beverage = beverage;
    }

    @Override
    public abstract String getDescription();

}
