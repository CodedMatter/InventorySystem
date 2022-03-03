package com.brian.items;

import com.brian.enums.Stat;

public class ManaPotion extends Potion {
    public ManaPotion() {
        super("Mana Potion", Stat.MANA, 10);
        super.setPrice(5);
    }
}
