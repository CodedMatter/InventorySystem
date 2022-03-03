package com.brian.items.armor;

public class Arms extends Armor{

    Arms(int defenceAmount) {
        super(defenceAmount);
    }

    @Override
    public boolean canEquip() {
        return false;
    }
}
