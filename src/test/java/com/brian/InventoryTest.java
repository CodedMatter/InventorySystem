package com.brian;

import com.brian.items.HealthPotion;
import com.brian.items.Item;
import com.brian.items.ManaPotion;
import com.brian.items.weapons.Sword;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();

        HealthPotion healthPotion = new HealthPotion();
        inventory.addItemToInventory(healthPotion);

        ManaPotion manaPotion = new ManaPotion();
        inventory.addItemToInventory(manaPotion);

        Sword basicSword = new Sword("Basic Sword", 15);
        Sword greatSword = new Sword("Great Sword", 55);
        inventory.addItemToInventory(basicSword);
        inventory.addItemToInventory(greatSword);
    }

    @Test
    void getItemList() {
        Assert.assertEquals("There should be 7 items in inventory", 7, inventory.getItemList().size());
    }

    @Test
    void addListToItems() {
        List<Item> itemsToAdd = new ArrayList<>();
        itemsToAdd.add(new Sword("Wood Sword",1));
        itemsToAdd.add(new Sword("Dragon Sword",45));
        Assert.assertEquals("Inventory should have 6 items", 6, inventory.addListToItems(itemsToAdd).size());
    }

    @Test
    void getAllItemsByID() {

    }

    @Test
    void getItemByID() {
    }

    @Test
    void getItemByName() {
    }

    @Test
    void addItemToInventory() {
    }

    @Test
    void removeItemFromInventory() {
    }

    @Test
    void recreateItemsMapWithIDs() {
    }

    @Test
    void categoriesByPrice() {
    }

    @Test
    void categorizeByName() {
    }
}