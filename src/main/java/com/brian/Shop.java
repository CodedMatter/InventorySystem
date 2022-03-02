package com.brian;

import com.brian.characters.Character;
import com.brian.items.Item;

import java.util.List;
import java.util.Scanner;

public class Shop extends Inventory{

    public Shop(List<Item> itemsToSell){
        super.addListToItems(itemsToSell);
    }

    public Item itemSelection(Scanner input){
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
    public boolean enoughBalanceToSellItem(double shopKeeperBalance, Item itemToSell){
        if(shopKeeperBalance>itemToSell.getPrice()){
            return true;
        }
        else{
            return false;
        }
    }

    public double purchaseItem(Character characterBuying, Item itemToPurchase){
        removeItemFromInventory(itemToPurchase);
        characterBuying.changeBalance(-itemToPurchase.getPrice());
        characterBuying.addItemToInventory(itemToPurchase);
        return itemToPurchase.getPrice();
    }

    public double sellItem(Character characterSelling, Item itemSelected) {
        removeItemFromInventory(itemSelected);
        characterSelling.changeBalance(itemSelected.getPrice());
        characterSelling.removeItemFromInventory(itemSelected);
        return itemSelected.getPrice();
    }

    public boolean isShopEmpty(){
        if(getItemList().size() == 0){
            return true;
        }
        else{
            return false;
        }
    }
}
