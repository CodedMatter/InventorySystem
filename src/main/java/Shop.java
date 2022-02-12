import java.util.List;

public class Shop extends Inventory{

    public Shop(List<Item> itemsToSell){
        super();
        super.getItemList().addAll(itemsToSell);
    }
}
