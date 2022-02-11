import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> itemList = new ArrayList<>();

    public void addItemToInventory(Item itemToAdd ){
        itemList.add(itemToAdd);
    }

    public void printInventory(){
        for(Item item : itemList){
            System.out.println(item);
        }
    }
}
