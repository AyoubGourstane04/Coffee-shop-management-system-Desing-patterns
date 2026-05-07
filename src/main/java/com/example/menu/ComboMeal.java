package com.example.menu;

import com.example.core.MenuComponent;
import com.example.pricing.Beverage;

//Builder
public class ComboMeal implements MenuComponent{
    private final Beverage drink;
    private final MenuComponent food;
    private final Double discount;

    private ComboMeal(Builder builder){
        this.drink = builder.drink;
        this.food = builder.food;
        this.discount = builder.discount;
    }

    @Override
    public String getName(){
        return "Combo Meal (" +
                (food != null? food.getName() : "No Food") + " + " +
                (drink != null? drink.getName() : "No Drink") + ")" ;
    }

    @Override
    public Double getPrice(){
        double total = 0.0;
        if(drink != null) total += drink.getPrice();
        if(food != null) total += food.getPrice();

        return Math.max(0.0, total - discount);
    }

    @Override
    public void print(){
        System.out.println("  " + getName() + " : " + getPrice() + " dh");
        System.out.println("      - Includes discount: -"+ discount +" dh");
    }


    public static class Builder{
        private Beverage drink = null;
        private MenuComponent food = null;
        private Double discount = 0.0;

        public Builder addDrink(Beverage drink){
            this.drink = drink;
            return this;
        }

        public Builder addFood(MenuComponent food){
            this.food = food;
            return this;
        }

        public Builder applyDiscount(Double discount){
            this.discount = discount;
            return this;
        }

        public ComboMeal build(){
            return new ComboMeal(this);
        }

    }
}
