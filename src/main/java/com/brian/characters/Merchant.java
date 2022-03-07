package com.brian.characters;

import com.brian.Shop;
import com.brian.items.HealthPotion;
import com.brian.items.Item;
import com.brian.items.ManaPotion;
import com.brian.items.weapons.Sword;

import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Merchant extends Character {

    Scanner input;
    Player playerInteractingWith;

    public Merchant(String name) {
        super(name);
        super.changeBalance(100);
        stockMerchantInventory();
        input = new Scanner(System.in);
    }

    private void stockMerchantInventory(){
        HealthPotion healthPotion = new HealthPotion();
        addItemToInventory(healthPotion);
        healthPotion.setPrice(15);
        healthPotion.setWeight(5);

        ManaPotion manaPotion = new ManaPotion();
        addItemToInventory(manaPotion);
        manaPotion.setPrice(10);
        manaPotion.setWeight(3);

        Sword basicSword = new Sword("Basic Sword", 15);
        Sword greatSword = new Sword("Great Sword", 55);
        addItemToInventory(basicSword);
        basicSword.setPrice(45);
        basicSword.setWeight(10);
        addItemToInventory(greatSword);
        greatSword.setPrice(35);
        greatSword.setWeight(8);
    }


    public void talkWith(Player withWhichPlayer){
        playerInteractingWith = withWhichPlayer;
        System.out.println("Hello there!");
        boolean isTalkingToMerchant = true;
        while (isTalkingToMerchant){
            System.out.println("Want to see my goods");
            System.out.println("1) Yes");
            System.out.println("2) No");
            System.out.print("Your Choice: ");
            String playerAnswer = playerInput();
            System.out.println();
            if(playerAnswer.equals("2") || playerAnswer.equals("no")){
                isTalkingToMerchant = false;
                System.out.println("Ok then lad. See you around");
                System.out.println();
                return;
            }
            else if(playerAnswer.equals("1") || playerAnswer.equals("yes")){
                openShop();

            }
            else {
                System.out.println("I dont understand you lad. Say again.");
                System.out.println();
                return;
            }
        }
    }

    private void openShop() {
        boolean exitShop = false;
        String playerAnswer = "";
        System.out.println("------------------------------");
        while(!exitShop){
            System.out.println("Do you wish buy or sell?");
            System.out.println("1) Buy");
            System.out.println("2) Sell");
            System.out.println("3) Exit");
            System.out.print("Your Choice: ");

            playerAnswer = playerInput();
            System.out.println();

            if(playerAnswer.equals("1") || playerAnswer.equals("buy")){
                Shop shop = new Shop(getItemList());
                if(!shop.isShopEmpty()){
                    System.out.println(shop.getInventoryWithIDAsString());
                    System.out.println("1)Choose Item To Purchase");
                    System.out.println("2)Categorize Items");
                    System.out.print("Your Choice: ");
                    playerAnswer = input.nextLine().replace(" ", "");
                    System.out.println();

                    while (!playerAnswer.equals("1") && !playerAnswer.equals("2")){
                        System.out.println("Choose A Valid Input");
                        System.out.println("1)Choose Item To Purchase");
                        System.out.println("2)Categorize Items");
                        System.out.print("Your Choice: ");
                        playerAnswer = input.nextLine().replace(" ", "");
                        System.out.println();
                    }

                    if(playerAnswer.equals("1")){
                        System.out.println("Pick Item To Buy");
                        System.out.print("Your Choice: ");
                        Item itemSelected = shop.itemSelection(input);
                        System.out.println();
                        if(itemSelected==null){
                            while (itemSelected == null){
                                System.out.println("That wasn't a valid choice");
                                System.out.println("Which item do you want to buy? ");
                                System.out.print("Your Choice: ");
                                itemSelected = shop.itemSelection(input);
                                System.out.println();
                            }
                        }
                        else{
                            if(shop.enoughBalanceToPurchaseItem(playerInteractingWith.getBalance(),itemSelected)){
                                changeBalance(shop.purchaseItem(playerInteractingWith,itemSelected));
                                removeItemFromInventory(itemSelected);
                            }
                            else{
                                System.out.println("You dont have enough for that.");
                                System.out.println();
                            }
                        }
                    }
                    else if(playerAnswer.equals("2")){
                        System.out.println("Categorize By:");
                        System.out.println("1)Name");
                        System.out.println("2)Price");
                        System.out.println("3)Weight");
                        System.out.println("4)Item Type");
                        System.out.println("Your Choice: ");
                        playerAnswer = input.nextLine().replace(" ", "");
                        System.out.println();

                        if(playerAnswer.equals("1")){
                            shop.recreateItemsMapWithIDs(shop.categorizeByName());
                        }
                        else if(playerAnswer.equals("2")){
                            shop.recreateItemsMapWithIDs(shop.categoriesByPrice());
                        }
                        else if(playerAnswer.equals("3")){
                            shop.recreateItemsMapWithIDs(shop.categorizeByWeight());
                        }
                        else if(playerAnswer.equals("4")){
                            shop.recreateItemsMapWithIDs(shop.catergorizeByCategory());
                        }

                        System.out.println(shop.getInventoryWithIDAsString());

                        System.out.println("Which item do you want to buy? ");
                        System.out.print("Your Choice: ");
                        Item itemSelected = shop.itemSelection(input);
                        System.out.println();
                        if(itemSelected==null){
                            while (itemSelected == null){
                                System.out.println("That wasn't a valid choice");
                                System.out.println("Which item do you want to buy? ");
                                System.out.print("Your Choice: ");
                                itemSelected = shop.itemSelection(input);
                                System.out.println();
                            }
                        }
                        else{
                            if(shop.enoughBalanceToPurchaseItem(playerInteractingWith.getBalance(),itemSelected)){
                                changeBalance(shop.purchaseItem(playerInteractingWith,itemSelected));
                                removeItemFromInventory(itemSelected);
                            }
                            else{
                                System.out.println("You dont have enough for that.");
                                System.out.println();
                            }
                        }

                    }
                }
                else{
                    System.out.println("Hhmm. Looks like I have nothing to sell.");
                    System.out.println();
                }

            }
            else if(playerAnswer.equals("2") || playerAnswer.equals("sell")){
                Shop shop = new Shop(playerInteractingWith.getItemList());
                if(!shop.isShopEmpty()){
                    //shop.printInventoryWithID();
                    System.out.println(shop.getInventoryWithIDAsString());
                    System.out.println("Which item do you want to sell? ");
                    System.out.print("Your Choice: ");
                    Item itemSelected = shop.itemSelection(input);
                    System.out.println();
                    if(itemSelected==null){
                        while (itemSelected == null){
                            System.out.println("That wasn't a valid choice");
                            System.out.println("Which item do you want to sell? ");
                            System.out.print("Your Choice: ");
                            itemSelected = shop.itemSelection(input);
                            System.out.println();
                        }
                    }
                    else{
                        if(shop.enoughBalanceToSellItem(getBalance(),itemSelected)){
                            changeBalance(-shop.sellItem(playerInteractingWith,itemSelected));
                            addItemToInventory(itemSelected);
                        }
                        else{
                            System.out.println("I dont have enough to buy that from you.");
                            System.out.println();
                        }
                    }
                }
                else{
                    System.out.println("You have no items to sell lad.");
                    System.out.println();
                }

            }
            else if (playerAnswer.equals("3") || playerAnswer.equals("exit")){
                exitShop = true;
            }
            else{
                System.out.println("I dont understand you lad.");
                System.out.println();
            }
        }
    }

    public String playerInput(){
        return input.nextLine().trim().
                toLowerCase().replace(" ","");
    }
}
