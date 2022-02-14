import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Shop extends Inventory{

    public Shop(List<Item> itemsToSell){
        super.setItemList(itemsToSell);
    }

    public void itemSelection(Scanner input){
        System.out.println("Which item do you want to buy? ");
        String playerAnswer = input.nextLine();
        if(PlayerInput.isPlayerInputID(playerAnswer)){

        }
        else{

        }
        // check if it matches the item id or name
        // check if there is enough balance to purchase
        // if enough balance to purchase then purchase
        // remove from inventory
        // add funds to merchant
        // remove balance from player
        // add item to player inventory
        // loop
    }
}
