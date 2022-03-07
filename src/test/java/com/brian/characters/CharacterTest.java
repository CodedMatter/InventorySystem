package com.brian.characters;

import com.brian.enums.ArmorPlacement;
import com.brian.enums.Stat;
import com.brian.items.armor.Chest;
import com.brian.items.armor.Helmet;
import com.brian.items.armor.Pants;
import com.brian.items.weapons.Sword;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    Character character;
    Helmet goldenHelmet;
    Pants leatherPants;

    @BeforeEach
    void setUp(){
        // Create Stats for test player
        Map<Stat,Integer> stats = new HashMap<>();
        stats.put(Stat.HEALTH,100);
        stats.put(Stat.MANA,80);
        stats.put(Stat.ATTACK, 10);

        // Create test character
        character = new Character("Test Character",
                "This is Character Description", stats, 100.00);
         goldenHelmet = new Helmet("Golden Helmet",10);
         character.equipArmor(goldenHelmet);
        leatherPants = new Pants("Leather Pants",12);
        character.equipArmor(leatherPants);
    }

    @Test
    void getName() {
        Assert.assertEquals("Name should be equal: Test Character",
                "Test Character",
                character.getName());
    }

    @Test
    void getDescription() {
        Assert.assertEquals("Should equal: This is Character Description",
                "This is Character Description",
                character.getDescription());
    }

    @Test
    void setDescription() {
        character.setDescription("Description was Changed");
        Assert.assertEquals("Should equal: Description was Changed",
                "Description was Changed",
                character.getDescription());
    }

    @Test
    void getBalance() {
        Assert.assertEquals("Should return a double number of 100",
                100.00, character.getBalance(), 0.01);
    }

    @Test
    void getStats() {
        Assert.assertEquals("Size of map should be 3",3,character.getStats().size());
    }

    @Test
    void getSpecificStat() {
        Assert.assertEquals("Health should be 100",100,character.getSpecificStat(Stat.HEALTH));
        Assert.assertEquals("Mana should be 80",80,character.getSpecificStat(Stat.MANA));
        Assert.assertEquals("Attack should be 10",10,character.getSpecificStat(Stat.ATTACK));
    }

    @Test
    void changeStatByAmount() {
        Assert.assertEquals("Adding 20 to health should equal 120",120,character.changeStatByAmount(Stat.HEALTH,20));
        Assert.assertEquals("Removing 20 from mana should equal 60",60,character.changeStatByAmount(Stat.MANA,-20));
    }

    @Test
    void hasStat() {
        Assert.assertTrue(character.hasStat(Stat.HEALTH));
        Assert.assertFalse(character.hasStat(Stat.DEFENCE));
    }

    @Test
    void removeArmor() {
        character.removeArmor(goldenHelmet);
        Assert.assertEquals("Should return null",null,character.getArmorEquipped().get(goldenHelmet));
        character.removeArmor(ArmorPlacement.PANTS);
        Assert.assertEquals("Should return null",null,character.getArmorEquipped().get(ArmorPlacement.PANTS));

    }

    @Test
    void equipArmor() {
        Chest goldenChest = new Chest("Golden Chest",15);
        character.equipArmor(goldenChest);
        Assert.assertEquals("Should return the Golden Chest armor",
                goldenChest,
                character.getArmorEquipped().get(ArmorPlacement.CHEST));
    }

    @Test
    void equipWeapon() {
        Sword basicSword = new Sword("Basic Sword", 15);
        character.equipWeapon(basicSword);
        Assert.assertEquals("Equipped weapon should be: Basic Sword",
                basicSword, character.getEquippedWeapon());
    }

    @Test
    void removeEquippedWeapon() {
        character.removeEquippedWeapon();
        Assert.assertEquals("Equipped weapon should be null",
                null,
                character.getEquippedWeapon());
    }

    @Test
    void changeBalance() {
        Assert.assertEquals("Adding 20 to balance should be 120",120,character.changeBalance(20),0.01);
        Assert.assertEquals("Removing 40 from balance should be 80",80,character.changeBalance(-40), 0.01);
    }
}