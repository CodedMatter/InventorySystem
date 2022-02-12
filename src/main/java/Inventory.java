import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> itemList;

    public Inventory(){
        itemList = new ArrayList<>();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItemToInventory(Item itemToAdd ){
        itemList.add(itemToAdd);
    }
    public void removeItemFromInventory(Item itemToRemove){
        itemList.remove(itemToRemove);
    }

    public void printInventory(){
        for(Item item : itemList){
            System.out.println(item);
        }
    }
}
