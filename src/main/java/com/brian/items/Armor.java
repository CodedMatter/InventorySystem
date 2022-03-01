package com.brian.items;

public abstract class Armor implements Equipable {
    int defenceAmount;

    Armor(int defenceAmount){
        this.defenceAmount = defenceAmount;
    }
}
