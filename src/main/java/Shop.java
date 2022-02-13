import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop extends Inventory{
    Map<Integer,Item> itemsByID;
    public Shop(List<Item> itemsToSell){
        super();
        super.getItemList().addAll(itemsToSell);
        itemsByID = new HashMap<>();
        int itemID = 1;
        for (Item item : getItemList()){
            itemsByID.put(itemID,item);
            itemID++;
        }
    }

    public void printShop() {
        for (int i = 1; i <= itemsByID.size(); i++) {
            Item item = itemsByID.get(i);
            System.out.println(i + ")" +
                    item);
        }
    }
}
