package com.brian.items;
import com.brian.interfaces.Equipable;

public abstract class Weapon implements Equipable {
    int attackAmount;

    Weapon(int attackAmount){
        this.attackAmount = attackAmount;
    }
}
