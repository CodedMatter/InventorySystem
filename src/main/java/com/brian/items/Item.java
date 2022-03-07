package com.brian.items;

import com.brian.characters.Player;
import com.brian.enums.Category;
import com.brian.items.armor.Armor;
import com.brian.items.weapons.Weapon;

import java.util.Scanner;

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
        System.out.println();
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void inspectItem(Scanner input, Player playerInspecting){
        String playerAnswer;
        System.out.println(this);
        if(category == Category.ARMOR){
            System.out.println("1) Equip Armor");
            System.out.println("2) Exit");
            System.out.print("Your Choice: ");
            playerAnswer = input.nextLine().replace(" ", "");
            System.out.println();
            if(playerAnswer.equals("1")){
                playerInspecting.equipArmor((Armor) this);
                playerInspecting.removeItemFromInventory(this);
                return;
            }
            else if (playerAnswer.equals("2")){
                return;
            }
            else{
                System.out.println("Need to input a valid choice");
                inspectItem(input,playerInspecting);
                return;
            }
        }
        else if(category == Category.WEAPON){
            System.out.println("1) Equip Weapon");
            System.out.println("2) Exit");
            System.out.print("Your Choice: ");
            playerAnswer = input.nextLine().replace(" ", "");
            System.out.println();
            if(playerAnswer.equals("1")){
                playerInspecting.equipWeapon((Weapon) this);
                playerInspecting.removeItemFromInventory(this);
                return;
            }
            else if (playerAnswer.equals("2")){
                return;
            }
            else{
                System.out.println("Need to input a valid choice");
                inspectItem(input,playerInspecting);
                return;
            }
        }
        else if(category == Category.POTION){
            System.out.println("1) Consume Potion");
            System.out.println("2) Exit");
            System.out.print("Your Choice: ");
            playerAnswer = input.nextLine().replace(" ", "");
            System.out.println();
            if(playerAnswer.equals("1")){
                if(this instanceof HealthPotion){
                    ((HealthPotion)this).consume(playerInspecting);
                }
                else if(this instanceof ManaPotion){
                    ((ManaPotion)this).consume(playerInspecting);
                }
                playerInspecting.removeItemFromInventory(this);
                return;
            }
            else if (playerAnswer.equals("2")){
                return;
            }
            else{
                System.out.println("Need to input a valid choice");
                inspectItem(input,playerInspecting);
                return;
            }
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "|| Category: " + category +
                "|| Price: " + price + "|| Weight: " + weight +
                "kg" + " || Description: " + description;
    }
}
