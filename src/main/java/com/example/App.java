package com.example;


import com.example.core.MenuComponent;
import com.example.core.StoreManager;
import com.example.menu.ComboMeal;
import com.example.menu.ItemFactory;
import com.example.menu.MenuCategory;
import com.example.order.Order;
import com.example.order.OrderCommand;
import com.example.order.PlaceOrderCommand;
import com.example.payment.CreditCardPayment;
import com.example.pricing.Beverage;
import com.example.pricing.Coffee;
import com.example.pricing.MilkDecorator;
import com.example.pricing.SugarDecorator;
import com.example.system.KitchenMonitor;
import com.example.system.OrderProcessingFacade;
import com.example.system.WaiterView;

import java.util.Stack;

public class App
{
    public static void main( String[] args )
    {
        System.out.println("====== STARTING COFFEE SHOP POS SYSTEM ======\n");

        StoreManager manager = StoreManager.getInstance();

        System.out.println("--- PHASE 1: BUILDING THE MENU ---");

        ItemFactory factory = new ItemFactory();
        MenuCategory breakfastMenu = new MenuCategory("Morning Menu");

        MenuComponent croissant = factory.createItem("croissant");
        breakfastMenu.add(croissant);

        Beverage fancyCoffee = new MilkDecorator(new SugarDecorator(new SugarDecorator(new Coffee())));
        breakfastMenu.add(fancyCoffee);

        MenuComponent morningCombo = new ComboMeal.Builder()
                .addDrink(new Coffee())
                .addFood(factory.createItem("muffin"))
                .applyDiscount(1.00)
                .build();
        breakfastMenu.add(morningCombo);

        breakfastMenu.print();


    
        System.out.println("\n--- PHASE 2: TAKING AN ORDER ---");

        Order order1 = new Order();
        KitchenMonitor kitchen = new KitchenMonitor("Station 1");
        WaiterView waiter = new WaiterView("Alice");

        order1.addObserver(kitchen);
        order1.addObserver(waiter);

        order1.addItem(croissant);
        order1.addItem(fancyCoffee);

        Stack<OrderCommand> commandHistory = new Stack<>();

        OrderCommand placeAction = new PlaceOrderCommand(order1);
        placeAction.execute();
        commandHistory.push(placeAction);

        System.out.println("\n*** Customer forgot wallet! Reverting... ***");
        OrderCommand lastCommand = commandHistory.pop();
        lastCommand.undo();

        System.out.println("\n*** Customer returns! Placing order again... ***");
        placeAction.execute();


        System.out.println("\n--- PHASE 3: CHECKOUT ---");

        order1.nextState();

        OrderProcessingFacade register = new OrderProcessingFacade();
        register.processCheckout(order1, new CreditCardPayment("John Doe", "1234567890123456"));


        manager.printDailyReport();
    }
}
