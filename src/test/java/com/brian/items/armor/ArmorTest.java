package com.brian.items.armor;

import com.brian.enums.ArmorPlacement;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArmorTest {

    Helmet goldenHelmet;
    Chest plateChest;
    Pants leatherPants;
    Arms gauntlet;
    Boots oldBoots;

    @BeforeEach
    void setUp(){
        goldenHelmet = new Helmet("Golden Helmet",10);
        plateChest = new Chest("Plated Chest", 15);
        leatherPants = new Pants("Leather Pants",12);
        gauntlet = new Arms("Gauntlet", 20);
        oldBoots = new Boots("Old Boots", 1);

    }

    @Test
    void getDefenceAmount() {
        Assert.assertEquals("Defense should be 10", 10 , goldenHelmet.getDefenceAmount());
        Assert.assertEquals("Defense should be 15", 15 , plateChest.getDefenceAmount());
        Assert.assertEquals("Defense should be 12", 12 , leatherPants.getDefenceAmount());
        Assert.assertEquals("Defense should be 20", 20 , gauntlet.getDefenceAmount());
        Assert.assertEquals("Defense should be 1", 1 , oldBoots.getDefenceAmount());
    }

    @Test
    void getArmorPlacement() {
        Assert.assertEquals("Defense should be 10", ArmorPlacement.HEAD, goldenHelmet.getArmorPlacement());
        Assert.assertEquals("Defense should be 15", ArmorPlacement.CHEST , plateChest.getArmorPlacement());
        Assert.assertEquals("Defense should be 12", ArmorPlacement.PANTS , leatherPants.getArmorPlacement());
        Assert.assertEquals("Defense should be 20", ArmorPlacement.ARMS , gauntlet.getArmorPlacement());
        Assert.assertEquals("Defense should be 1", ArmorPlacement.BOOTS , oldBoots.getArmorPlacement());
    }
}