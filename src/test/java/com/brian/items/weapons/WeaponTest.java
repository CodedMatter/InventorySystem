package com.brian.items.weapons;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeaponTest {

    Sword basicSword;

    @BeforeEach
    void setUp(){
        basicSword = new Sword("Basic Sword", 15);
    }

    @Test
    void getAttackAmount() {
        Sword basicSword = new Sword("Basic Sword", 15);
        Assert.assertEquals("Attack should be 15", 15 ,
                basicSword.getAttackAmount());
    }
}