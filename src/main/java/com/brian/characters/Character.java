package com.brian.characters;

import com.brian.Inventory;
import com.brian.Stat;

import java.util.HashMap;
import java.util.Map;

public class Character extends Inventory {
    private final String name;
    private String description;
    private Map<Stat, Integer> stats;
    private double balance;

    public Character(String name){
        this.name = name;
        description = "";
        stats = new HashMap<>();
        balance = 0;
    }
    public Character(String name,Map<Stat,Integer> stats){
        this.name = name;
        description = "";
        this.stats = stats;
        balance = 0;
    }

    public Character(String name, String description, Map<Stat, Integer> stats, double balance) {
        this.name = name;
        this.description = description;
        this.stats = stats;
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

    public void changeStat(Stat stat, int amount){
        stats.put(stat,(stats.get(stat) + amount));
    }

    public boolean hasStat(Stat stat) {
        return stats.containsKey(stat);
    }

    public void changeBalance(double amountOfMoney){
        balance += amountOfMoney;
    }
}
