import java.util.*;

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
    public void createItemListFromList(List<Item> itemList){
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

    public List<Item> categoriesByPrice(){
        List<Item> organizedItems = new ArrayList<>();
        organizedItems.addAll(getItemList());

        Collections.sort(organizedItems, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return (int) (item1.getPrice()-item2.getPrice());
            }
        });
        return organizedItems;
    }

    public List<Item> categorizeByName(){
        List<Item> organizedItems = new ArrayList<>();
        organizedItems.addAll(getItemList());
        Collections.sort(organizedItems, new Comparator<Item>() {
            @Override
            public int compare(Item item1, Item item2) {
                return item1.getName().compareTo(item2.getName());
            }
        });
        return organizedItems;
    }

    public String getInventoryWithoutIDAsString(){
        String output = "";
        for(Item item : itemList){
            output += item + "\n";
        }
        return output;
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