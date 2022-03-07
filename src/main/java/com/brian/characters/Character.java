package com.brian.characters;

import com.brian.Inventory;
import com.brian.enums.ArmorPlacement;
import com.brian.enums.Stat;
import com.brian.items.armor.Armor;
import com.brian.items.weapons.Weapon;

import java.util.HashMap;
import java.util.Map;

public class Character extends Inventory {
    private String name;
    private String description;
    private Map<Stat, Integer> stats;
    private Map<ArmorPlacement, Armor> armorEquiped;
    private Weapon equippedWeapon;
    private double balance;

    public Character(String name){
        this.name = name;
        description = "";

        stats = new HashMap<>();
        stats.put(Stat.HEALTH, 100);
        stats.put(Stat.MANA, 80);
        stats.put(Stat.DEFENCE, 50);
        stats.put(Stat.ATTACK, 15);

        armorEquiped = new HashMap<>();
        armorEquiped.put(ArmorPlacement.HEAD,null);
        armorEquiped.put(ArmorPlacement.CHEST,null);
        armorEquiped.put(ArmorPlacement.ARMS,null);
        armorEquiped.put(ArmorPlacement.PANTS,null);
        armorEquiped.put(ArmorPlacement.BOOTS,null);
        equippedWeapon = null;
        balance = 0;
    }

    public Character(String name, String description, Map<Stat, Integer> stats, double balance) {
        this.name = name;
        this.description = description;
        this.stats = stats;
        armorEquiped = new HashMap<>();
        armorEquiped.put(ArmorPlacement.HEAD,null);
        armorEquiped.put(ArmorPlacement.CHEST,null);
        armorEquiped.put(ArmorPlacement.ARMS,null);
        armorEquiped.put(ArmorPlacement.PANTS,null);
        armorEquiped.put(ArmorPlacement.BOOTS,null);
        equippedWeapon = null;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public double getBalance() {
        return balance;
    }

    public Map<Stat, Integer> getStats() {
        return stats;
    }

    public int getSpecificStat(Stat stat){
        return stats.get(stat);
    }

    public int changeStatByAmount(Stat stat, int amount){
        stats.put(stat,(stats.get(stat) + amount));
        return getSpecificStat(stat);
    }

    public boolean hasStat(Stat stat) {
        return stats.containsKey(stat);
    }

    public Map<ArmorPlacement, Armor> getArmorEquipped(){
        return armorEquiped;
    }

    public void removeArmor(Armor armorToRemove){
        for(Map.Entry<ArmorPlacement,Armor> armorEntry : getArmorEquipped().entrySet()){
            if(armorEntry.getValue() == armorToRemove){
                armorEntry.setValue(null);
                addItemToInventory(armorToRemove);
            }
        }
    }
    public void removeArmor(ArmorPlacement armorPlacement){
        if(getArmorEquipped().get(armorPlacement) != null){
            addItemToInventory(getArmorEquipped().get(armorPlacement));
            getArmorEquipped().put(armorPlacement,null);
        }
    }

    public void equipArmor(Armor armorToEquip){
        if(getArmorEquipped().get(armorToEquip.getArmorPlacement()) != null){
            removeArmor(armorToEquip.getArmorPlacement());
        }
        getArmorEquipped().put(armorToEquip.getArmorPlacement(), armorToEquip);
    }

    public void equipWeapon(Weapon weaponToEquip){
        if(getEquippedWeapon() != null){
            removeEquippedWeapon();
        }
        equippedWeapon = weaponToEquip;
    }
    public Weapon getEquippedWeapon(){
        return equippedWeapon;
    }
    public void removeEquippedWeapon(){
        if(getEquippedWeapon() != null){
            addItemToInventory(getEquippedWeapon());
        }
        equippedWeapon = null;
    }

    public double changeBalance(double amountOfMoney){
        balance += amountOfMoney;
        return balance;
    }
}
