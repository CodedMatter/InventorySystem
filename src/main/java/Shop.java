import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shop extends Inventory{

    public Shop(List<Item> itemsToSell){
        super.setItemList(itemsToSell);
    }

    public Item itemSelection(Scanner input){
        System.out.println("Which item do you want to buy? ");
        String playerAnswer = input.nextLine();
        Item itemSelected;
        if(PlayerInput.isPlayerInputID(playerAnswer)){
            itemSelected = getItemByID(Integer.parseInt(playerAnswer));
        }
        else{
            itemSelected = getItemByName(playerAnswer);
        }
        return itemSelected;
    }

    public boolean enoughBalanceToPurchaseItem(double playerBalance, Item itemToPurchase){
        if(playerBalance>itemToPurchase.getPrice()){
            return true;
        }
        else{
            return false;
        }
    }
    public double purchaseItem(Player player, Item itemToPurchase){
        removeItemFromInventory(itemToPurchase);
        player.lossBalance(itemToPurchase.getPrice());
        player.addItemToInventory(itemToPurchase);
        return itemToPurchase.getPrice();
    }
}
