package com.brian.items.weapons;
import com.brian.enums.Category;
import com.brian.items.Item;

public abstract class Weapon extends Item {
    private int attackAmount;

    public Weapon(String name, int attackAmount){
        super(name, Category.WEAPON);
        this.attackAmount = attackAmount;
    }

    public int getAttackAmount() {
        return attackAmount;
    }
}
