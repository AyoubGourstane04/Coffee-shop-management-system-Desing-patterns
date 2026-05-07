package com.example.menu;

import com.example.core.MenuComponent;

//Factory Method
public class ItemFactory {
    public MenuComponent createItem(String itemType){
        switch (itemType.toLowerCase()){
            case "espresso":
                return new MenuItem("Espresso", 2.50);
            case "dark roast":
                return new MenuItem("Dark Roast Coffee", 2.00);
            case "decaf":
                return new MenuItem("Decaf Coffee", 2.00);
            case "green tea":
                return new MenuItem("Green Tea", 2.25);
            case "croissant":
                return new MenuItem("Butter Croissant", 3.50);
            case "muffin":
                return new MenuItem("Blueberry Muffin", 3.00);
            case "sandwich":
                return new MenuItem("Turkey Sandwich", 5.50);
            case "latte":
                return new MenuItem("Caffe Latte", 3.75);
            case "cappuccino":
                return new MenuItem("Cappuccino", 3.50);
            case "americano":
                return new MenuItem("Americano", 2.75);
            case "mocha":
                return new MenuItem("Cafe Mocha", 4.25);
            case "macchiato":
                return new MenuItem("Caramel Macchiato", 4.50);
            case "flat white":
                return new MenuItem("Flat White", 3.80);
            case "iced coffee":
                return new MenuItem("Iced Coffee", 3.00);
            case "hot chocolate":
                return new MenuItem("Hot Chocolate", 3.25);
            case "chai latte":
                return new MenuItem("Chai Latte", 3.75);
            case "black tea":
                return new MenuItem("Black Tea", 2.25);
            case "cheesecake":
                return new MenuItem("Cheesecake Slice", 4.50);
            case "brownie":
                return new MenuItem("Chocolate Brownie", 3.25);
            case "cookies":
                return new MenuItem("Chocolate Chip Cookies", 2.75);
            case "bagel":
                return new MenuItem("Cream Cheese Bagel", 3.50);
            case "panini":
                return new MenuItem("Chicken Panini", 6.25);
            case "wrap":
                return new MenuItem("Caesar Chicken Wrap", 5.75);
            case "salad":
                return new MenuItem("Greek Salad", 5.25);
            case "donut":
                return new MenuItem("Glazed Donut", 2.50);
            case "fries":
                return new MenuItem("French Fries", 3.00);
            case "pizza":
                return new MenuItem("Mini Pepperoni Pizza", 7.50);

            default:
                throw new IllegalArgumentException("Error: [" + itemType + "] is not a valid menu item.");
        }
    }
}
