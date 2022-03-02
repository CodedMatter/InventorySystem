package com.brian.items.weapons;
import com.brian.Category;
import com.brian.interfaces.Equipable;
import com.brian.items.Item;

public abstract class Weapon extends Item implements Equipable {
    int attackAmount;

    Weapon(String name, int attackAmount){
        super(name, Category.WEAPON);

        this.attackAmount = attackAmount;
    }
}
