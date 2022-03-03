package com.brian.items.armor;

public class Pants extends Armor{

    Pants(int defenceAmount) {
        super(defenceAmount);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
