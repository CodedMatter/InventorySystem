package com.brian.items.armor;

public class Chest extends Armor {

    Chest(int defenceAmount) {
        super(defenceAmount);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}