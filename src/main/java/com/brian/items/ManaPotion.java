package com.brian.items;

import com.brian.Stat;

public class ManaPotion extends Potion {
    public ManaPotion() {
        super("Mana com.brian.items.Potion", Stat.MANA, 10);
        super.setPrice(5);
    }
}
