package com.brian.items.armor;

public class Boots extends Armor{

    Boots(int defenceAmount) {
        super(defenceAmount);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
