package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;

public class Chest extends Armor {

    public Chest(String name, int defenceAmount) {
        super(name, defenceAmount, ArmorPlacement.CHEST);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}