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
    public int consume(Character personConsuming) {
        if(personConsuming.hasStat(statToEffect)){
            personConsuming.changeStatByAmount(statToEffect,amount);
        }
        else{
            System.out.println(personConsuming.getName() + " doesnt have a " + statToEffect.name() + " stat.");
        }
        return personConsuming.getSpecificStat(statToEffect);
    }
}
