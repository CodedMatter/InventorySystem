package com.brian.items;

import com.brian.characters.Character;
import com.brian.enums.Category;
import com.brian.enums.Stat;
import com.brian.interfaces.Consumable;

public class Potion extends Item implements Consumable {

    public Stat statToEffect;
    public int amount;
    public Potion(String name, Stat statToEffect, int amount){
        super(name, Category.POTION);
        this.statToEffect = statToEffect;
        this.amount = amount;
    }

    @Override
    public void consume(Character personConsuming) {
        if(personConsuming.hasStat(statToEffect)){
            personConsuming.getStats().put(statToEffect,
                    personConsuming.getSpecificStat(Stat.HEALTH)+ amount);
        }
        else{
            System.out.println(personConsuming.getName() + " doesnt have a " + statToEffect.name() + " stat.");
        }
    }
}