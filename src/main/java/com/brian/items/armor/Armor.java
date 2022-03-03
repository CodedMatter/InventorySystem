package com.brian.items.armor;

import com.brian.interfaces.Equipable;
public abstract class Armor implements Equipable {
    int defenceAmount;


    Armor(int defenceAmount){
        this.defenceAmount = defenceAmount;
    }
}
