package com.brian.items.weapons;

public class Sword extends Weapon{

    public Sword(String name, int attackAmount) {
        super(name,attackAmount);
    }

    @Override
    public boolean canEquip() {
        // add requirements that need to be meet to equip
        return true;
    }
}
