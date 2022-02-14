import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    Inventory inventory;

    @BeforeEach
    void setUp() {
        inventory = new Inventory();
        for (int i = 0; i < 5; i++) {
            HealthPotion healthPotion = new HealthPotion();
            inventory.addItemToInventory(healthPotion);
        }

        for (int i = 0; i < 5; i++) {
            ManaPotion manaPotion = new ManaPotion();
            inventory.addItemToInventory(manaPotion);
        }
    }

    @Test
    void getItemList() {
        int numberOfItemsCreatedInSetUp = 10;
        assertEquals(numberOfItemsCreatedInSetUp, inventory.getItemList().size(),
                "There same amount of items created should show up");
    }

    @Test
    void addItemToInventory() {
        int sizeOfListBeforeAddingItem = inventory.getItemList().size();
        // create a new item to add to inventory
        Potion potion = new Potion("Unknown Potion");

        // add item to the list in inventory
        inventory.addItemToInventory(potion);

        // check if the list incremented by one
        assertEquals(sizeOfListBeforeAddingItem+1,
                inventory.getItemList().size(),
                "List size size should be 1 more then created size");

        // check if the item can be found in list
        assertTrue(inventory.getItemList().contains(potion),
                "Potion should be found in list");

    }

    @Test
    void removeItemFromInventory() {
        addItemToInventory();
        // get the last item added
        Item item = inventory.getItemList().get(inventory.getItemList().size()-1);
        int sizeOfListBeforeRemovingItem = inventory.getItemList().size();
        inventory.removeItemFromInventory(item);
        assertEquals(sizeOfListBeforeRemovingItem-1,
                inventory.getItemList().size(),
                "Should be an item less than initial size");
        assertFalse(inventory.getItemList().contains(item),
                "Item should not be found since it was removed");
    }
}