import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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

//    @Test
//    void addItemToInventory() {
//        int sizeOfListBeforeAddingItem = inventory.getItemList().size();
//        // create a new item to add to inventory
//        Potion potion = new Potion("Unknown Potion");
//
//        // add item to the list in inventory
//        inventory.addItemToInventory(potion);
//
//        // check if the list incremented by one
//        assertEquals(sizeOfListBeforeAddingItem+1,
//                inventory.getItemList().size(),
//                "List size size should be 1 more then created size");
//
//        // check if the item can be found in list
//        assertTrue(inventory.getItemList().contains(potion),
//                "Potion should be found in list");
//
//    }

//    @Test
//    void removeItemFromInventory() {
//        addItemToInventory();
//        // get the last item added
//        Item item = inventory.getItemList().get(inventory.getItemList().size()-1);
//        int sizeOfListBeforeRemovingItem = inventory.getItemList().size();
//        inventory.removeItemFromInventory(item);
//        assertEquals(sizeOfListBeforeRemovingItem-1,
//                inventory.getItemList().size(),
//                "Should be an item less than initial size");
//        assertFalse(inventory.getItemList().contains(item),
//                "Item should not be found since it was removed");
//    }

    @Test
    void getAllItemsByID() {
        // create how the map is supposed to be return
        // with the same items as inventory
        Map<Integer,Item> expectedMap = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            Item item = inventory.getItemList().get(i-1);
            expectedMap.put(i,item);
        }
        for (int i = 6; i <= 10; i++) {
            Item item = inventory.getItemList().get(i-1);
            expectedMap.put(i,item);
        }
        assertEquals(expectedMap,inventory.getAllItemsByID());
    }

//    @Test
//    void getItemByID() {
//        // add item to inventory
//        Item item = new Potion("Unknown Potion");
//        inventory.addItemToInventory(item);
//
//        // id of item should be the size of the
//        // map since it's the last item added
//        int idToSearch = inventory.getAllItemsByID().size();
//        // check if it returns with the correct id
//        assertEquals(item, inventory.getItemByID(idToSearch),"Should return the same item");
//    }

    @Test
    void printInventoryWithoutID() {
        String expected = "";
        for(Item item : inventory.getItemList()){
            expected += "Name: " + item.getName() +
                    " || Description: " + item.getDescription() + "\n";
        }

        assertEquals(expected,
                inventory.getInventoryWithoutIDAsString(),
                "Format Should be the same");
    }

    @Test
    void printInventoryWithID() {

        String expected = "";
        for (int i = 1; i <= inventory.getAllItemsByID().size(); i++) {
            Item item = inventory.getItemByID(i);
            expected += i + ")Name: " + item.getName() +
                    " || Description: " + item.getDescription() + "\n";
        }

        System.out.println(expected);
        System.out.println();
        System.out.println(inventory.getInventoryWithIDAsString());
        assertEquals(expected,
                inventory.getInventoryWithIDAsString(),
                "Format Should be the same");
    }
}