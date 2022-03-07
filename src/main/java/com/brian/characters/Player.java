package com.brian.characters;

import com.brian.enums.ArmorPlacement;
import com.brian.enums.Stat;
import com.brian.items.HealthPotion;
import com.brian.items.ManaPotion;
import com.brian.items.armor.Helmet;
import com.brian.items.weapons.Sword;

public class Player extends Character {

    public Player(String name) {
        super(name);
        super.changeBalance(100);
        HealthPotion healthPotion = new HealthPotion();
        ManaPotion manaPotion = new ManaPotion();
        Sword basicSword = new Sword("Basic Sword", 15);
        Sword greatSword = new Sword("Great Sword", 55);
        Helmet goldenHelmet = new Helmet("Golden Helmet",10);

        addItemToInventory(healthPotion);
        addItemToInventory(basicSword);
        addItemToInventory(goldenHelmet);
        addItemToInventory(greatSword);
        addItemToInventory(manaPotion);
    }

    public String checkStats() {
        String stats;
        stats = "Player Stats: \n" +
                "Health:" + getSpecificStat(Stat.HEALTH) + "\n" +
                "Mana: " + getSpecificStat(Stat.MANA) + "\n" +
                "Defense: " + getSpecificStat(Stat.DEFENCE) + "\n" +
                "Attack: " + getSpecificStat(Stat.ATTACK) + "\n";
        return stats;
    }

    public String checkEquipment(){
        String equipment;
        equipment = "Player Equipment: \n" +
                "Head Armor: " + getArmorEquipped().get(ArmorPlacement.HEAD) + "\n" +
                "Chest Armor: " + getArmorEquipped().get(ArmorPlacement.CHEST) + "\n" +
                "Arm Armor: " + getArmorEquipped().get(ArmorPlacement.ARMS) + "\n" +
                "Leg Armor: " + getArmorEquipped().get(ArmorPlacement.PANTS) + "\n" +
                "Boots Armor: " + getArmorEquipped().get(ArmorPlacement.BOOTS) + "\n" +
                "Weapon: " + getEquippedWeapon() + "\n";
        return equipment;
    }
}
