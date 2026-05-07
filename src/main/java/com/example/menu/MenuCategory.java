package com.example.menu;

import java.util.ArrayList;
import java.util.List;

import com.example.core.MenuComponent;

// Composite node
public class MenuCategory implements MenuComponent{
    public String name;
    public List<MenuComponent> components;

    public MenuCategory(String name){
        this.name = name;
        this.components = new ArrayList<>();
    }

    @Override
    public String getName(){
        return this.name;
    }

    @Override
    public void print(){
        System.out.println("================ " + getName() + " Menu : ================");
        for(MenuComponent component : components){
            component.print();
        }
    }

    @Override
    public void add(MenuComponent component){
        components.add(component);
    }

    @Override
    public void remove(MenuComponent component){

        if(components.remove(component)){
            System.out.println(component.getName() + " Added Successfully!");
        }else{
            System.out.println("Component doesn't exist!");
        }
    }

}
