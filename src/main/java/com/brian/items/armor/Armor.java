package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;
import com.brian.enums.Category;
import com.brian.interfaces.Equipable;
import com.brian.items.Item;

public abstract class Armor extends Item implements Equipable {
    private int defenceAmount;
    private ArmorPlacement armorPlacement;

    public Armor(String name, int defenceAmount, ArmorPlacement armorPlacement){
        super(name, Category.ARMOR);
        this.defenceAmount = defenceAmount;
        this.armorPlacement = armorPlacement;
    }

    public int getDefenceAmount() {
        return defenceAmount;
    }

    public ArmorPlacement getArmorPlacement() {
        return armorPlacement;
    }
}
