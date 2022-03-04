package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;

public class Pants extends Armor{

    public Pants(String name, int defenceAmount) {
        super(name, defenceAmount, ArmorPlacement.PANTS);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
