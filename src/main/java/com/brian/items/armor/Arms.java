package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;

public class Arms extends Armor{

    public Arms(String name, int defenceAmount) {
        super(name,defenceAmount, ArmorPlacement.ARMS);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
