package com.brian.items;

import com.brian.enums.Stat;

public class HealthPotion extends Potion {
    public HealthPotion(){
        super("Health Potion", Stat.HEALTH, 10);
        super.setPrice(10);
    }
}
