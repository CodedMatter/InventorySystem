package com.brian;

import com.brian.enums.Stat;
import com.brian.characters.Character;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CharacterTest {

    Character character;

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
    void changeBalance() {
        Assert.assertEquals("Adding 20 to balance should be 120",120,character.changeBalance(20),0.01);
        Assert.assertEquals("Removing 40 from balance should be 80",80,character.changeBalance(-40), 0.01);
    }

    //TODO add a tests for armor

}