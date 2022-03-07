package com.brian.items;

import com.brian.enums.Stat;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.brian.characters.Character;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {
    Character testCharacter;
    @BeforeEach
    void setUp(){
        // Create Stats for test player
        Map<Stat,Integer> stats = new HashMap<>();
        stats.put(Stat.HEALTH,100);
        stats.put(Stat.MANA,80);
        stats.put(Stat.ATTACK, 10);

        // Create test character
        testCharacter = new Character("Test Character",
                "This is Character Description", stats, 100.00);
    }

    @Test
    void consume() {
        // potion increase stat by 10
        HealthPotion healthPotion = new HealthPotion();
        ManaPotion manaPotion = new ManaPotion();

         Assert.assertEquals("Health should be 110",
                  110, healthPotion.consume(testCharacter));
        Assert.assertEquals("Mana should be " + 90,
                90, manaPotion.consume(testCharacter));
    }
}