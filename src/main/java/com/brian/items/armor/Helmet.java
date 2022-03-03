package com.brian.items.armor;

public class Helmet extends Armor{

    Helmet(int defenceAmount) {
        super(defenceAmount);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
