package com.brian;

import com.brian.items.HealthPotion;
import com.brian.items.Item;
import com.brian.items.ManaPotion;
import com.brian.items.armor.Helmet;
import com.brian.items.weapons.Sword;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.InflaterInputStream;

class InventoryTest {

    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();

        HealthPotion healthPotion = new HealthPotion();
        inventory.addItemToInventory(healthPotion);
        healthPotion.setPrice(15);

        ManaPotion manaPotion = new ManaPotion();
        inventory.addItemToInventory(manaPotion);
        manaPotion.setPrice(10);

        Sword basicSword = new Sword("Basic Sword", 15);
        Sword greatSword = new Sword("Great Sword", 55);
        inventory.addItemToInventory(basicSword);
        basicSword.setPrice(45);
        inventory.addItemToInventory(greatSword);
        greatSword.setPrice(35);
    }

    @Test
    void getItemList() {
        Assert.assertEquals("There should be 4 items in inventory", 4, inventory.getItemList().size());
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
        Item firstItem = inventory.getItemList().get(0);
        Assert.assertEquals("Should return the first item in the item list",
                firstItem,inventory.getAllItemsByID().get(1));

        Item lastItem = inventory.getItemList().get(3);
        Assert.assertEquals("Should return last item in the list",
                lastItem, inventory.getAllItemsByID().get(4));

    }

    @Test
    void getItemByID() {
        Item firstItem = inventory.getItemList().get(0);
        Assert.assertEquals("ID 1 should return the first item on the inventory list",
                firstItem, inventory.getItemByID(1));
    }

    @Test
    void getItemByName() {
        Assert.assertEquals("Should return item called Basic Sword",
                "Basic Sword",inventory.getItemByName("Basic Sword").getName());
        Assert.assertEquals("If no item with the name then return null",
                null, inventory.getItemByName("Golden Helmet"));
    }

    @Test
    void addItemToInventory() {
        Helmet goldenHelmet = new Helmet("Golden Helmet",10);
        inventory.addItemToInventory(goldenHelmet);
        Assert.assertEquals("There should be 5 items now on the list",
                5 , inventory.getItemList().size());
        Assert.assertTrue("Should contain: Golden Helmet",
                inventory.getItemList().contains(goldenHelmet));
    }

    @Test
    void removeItemFromInventory() {
        Item itemToRemove = inventory.getItemList().get(0);
        inventory.removeItemFromInventory(itemToRemove);
        Assert.assertEquals("After Removing item thereshould only be 3 items",
                3, inventory.getItemList().size());
        Assert.assertFalse("The item {" +
                itemToRemove.getName() + "} Should not be in the list",
                inventory.getItemList().contains(itemToRemove));
    }

    @Test
    void recreateItemsMapWithIDs() {
    }

    @Test
    void categoriesByPrice() {
        Assert.assertEquals("Mana potion should be first since cheapest",
                "Mana Potion", inventory.categoriesByPrice().get(0).getName());
        Assert.assertEquals("Last item should be Basic Sword",
                "Basic Sword", inventory.categoriesByPrice().get(3).getName());
    }

    @Test
    void categorizeByName() {
        Assert.assertEquals("Basic Sword should be first",
                "Basic Sword",
                inventory.categorizeByName().get(0).getName());
        Assert.assertEquals("Mana potion should be last",
                "Mana Potion",
                inventory.categorizeByName().get(3).getName());
    }

    @Test
    void categorizeByWeight(){

    }
}