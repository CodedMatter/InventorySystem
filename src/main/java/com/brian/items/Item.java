package com.brian.items;

import com.brian.Category;

public class Item {
    private final String name;
    private String description;
    private double price;
    private Category category;
    private double weight;

    public Item(String name, String description, Category category, double weight){
        this.name = name;
        this.description = description;
        price = 0;
        this.category = category;
        this.weight = weight;
    }

    public Item(String name, Category category){
        this.name = name;
        price = 0;
        this.category =  category;
        weight = 0;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double newItemPrice) {
        if(newItemPrice < 0){
            price = 0;
        }
        else {
            price = newItemPrice;
        }
    }

    public Category getCategory(){
        return category;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Name: " + name + "|| com.brian.Category: " + category +
                "|| Price: " + price + "|| Weight: " + weight +
                "kg" + " || Description: " + description;
    }
}
