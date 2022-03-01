package com.brian.items;

import com.brian.Stat;

public class HealthPotion extends Potion {
    public HealthPotion(){
        super("Health com.brian.items.Potion", Stat.HEALTH, 10);
        super.setPrice(10);
    }
}
