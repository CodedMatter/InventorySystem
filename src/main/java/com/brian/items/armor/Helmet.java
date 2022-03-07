package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;

public class Helmet extends Armor{

    public Helmet(String name, int defenceAmount) {
        super(name, defenceAmount, ArmorPlacement.HEAD);
    }

}
