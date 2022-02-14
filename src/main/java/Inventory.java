import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventory {
    private List<Item> itemList;
    private Map<Integer,Item> itemsByID;
    private int lastIDForItemsAdded;

    public Inventory(){
        itemList = new ArrayList<>();
        itemsByID = new HashMap<>();
        lastIDForItemsAdded = 0;
    }

    public List<Item> getItemList() {
        return itemList;
    }
    public void setItemList(List<Item> itemList){
        for (Item item : itemList){
            addItemToInventory(item);
        }
    }

    public Map<Integer,Item> getAllItemsByID(){
        return itemsByID;
    }
    public Item getItemByID(int id){
        return itemsByID.get(id);
    }
    public Item getItemByName(String nameOfItem){
        Item itemToReturn;
        for(Item item : itemList){
            if(item.getName().equals(nameOfItem)){
                return item;
            }
        }
        return null;
    }

    public void addItemToInventory(Item itemToAdd ){
        lastIDForItemsAdded++;
        itemList.add(itemToAdd);
        itemsByID.put(lastIDForItemsAdded,itemToAdd);

    }

    public void removeItemFromInventory(Item itemToRemove){
        itemList.remove(itemToRemove);
        recreateItemsMapWithIDs(itemList);

    }

    public void recreateItemsMapWithIDs(List<Item> itemList){
        itemsByID = new HashMap<>();
        lastIDForItemsAdded = 0;
        for (Item item: itemList){
            lastIDForItemsAdded++;
            itemsByID.put(lastIDForItemsAdded,item);

        }
    }

    public void printInventoryWithoutID(){
        for(Item item : itemList){
            System.out.println(item);
        }
    }
    public String getInventoryWithoutIDAsString(){
        String output = "";
        for(Item item : itemList){
            output += item + "\n";
        }
        return output;
    }
    public void printInventoryWithID(){
        for (int i = 1; i <= itemsByID.size(); i++) {
            Item item = itemsByID.get(i);
            System.out.println(i + ")" +
                    item);
        }
    }
    public String getInventoryWithIDAsString(){
        String output = "";
        for (int i = 1; i <= itemsByID.size(); i++) {
            Item item = itemsByID.get(i);
            output += i + ")" + item + "\n";
        }
        return output;

    }

}
