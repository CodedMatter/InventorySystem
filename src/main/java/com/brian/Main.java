package com.brian;

import com.brian.characters.Merchant;
import com.brian.characters.Player;
import com.brian.items.Item;

import java.util.Scanner;

public class Main {
    Scanner input;
    Player player;
    Merchant merchant;

    public static void main(String[] args) {
        Main program = new Main();
        program.input = new Scanner(System.in);
        program.player = new Player("Brian");
        program.merchant = new Merchant("Merchant");

        program.mainDialogue();

    }

    public void mainDialogue(){
        boolean isValidAnswer = false;
        while (!isValidAnswer){
            System.out.println("1) Inspect Player");
            System.out.println("2) Talk To Merchant");
            System.out.println("3) Exit");
            System.out.print("Your Choice: ");
            String playerAnswer = input.nextLine().replace(" ", "");
            System.out.println();
            if(playerAnswer.equals("1")){
                // check inventory
                isValidAnswer = true;
                inspectPlayer();
            }
            else if(playerAnswer.equals("2")){
                isValidAnswer = true;
                merchant.talkWith(player);
                mainDialogue();
            }
            else if(playerAnswer.equals("3")){
                return;
            }
            else{
                System.out.println("Input A Valid Choice");
            }
        }
    }

    public void inspectPlayer() {
        System.out.println("1)Check Player Stats");
        System.out.println("2)Check Equipment");
        System.out.println("3)Check Player Inventory");
        System.out.println("4)Exit");
        System.out.print("Your Choice: ");
        String playerAnswer = input.nextLine().replace(" ", "");
        System.out.println();
        // reset inventory order in case it was organized by player earlier
        player.recreateItemsMapWithIDs(player.getItemList());
        if(playerAnswer.equals("1")){
            System.out.println(player.checkStats());
            inspectPlayer();
            return;
        }
        else if(playerAnswer.equals("2")){
            System.out.println(player.checkEquipment());
            inspectPlayer();
            return;
        }
        else if(playerAnswer.equals("3")){
            boolean exitInventory = false;
            while (!exitInventory){
                System.out.println(player.getInventoryWithIDAsString());
                System.out.println();
                System.out.println("1)Inspect Item");
                System.out.println("2)Categorize Inventory");
                System.out.println("3)Exit Inventory");
                System.out.print("Your Choice: ");
                playerAnswer = input.nextLine().replace(" ", "");
                System.out.println();
                if(playerAnswer.equals("1")){
                    System.out.println("What item do you want to inspect: ");
                    System.out.print("Your Choice: ");
                    playerAnswer = input.nextLine().replace(" ", "");
                    System.out.println();
                    Item itemSelected = player.getItemByID(Integer.parseInt(playerAnswer));
                    if(itemSelected==null){
                        while (itemSelected == null){
                            System.out.println("That wasn't a valid choice");
                            System.out.println("Which item do you want to inspect:");
                            System.out.print("Your Choice: ");
                            playerAnswer = input.nextLine().replace(" ", "");
                            System.out.println();
                            itemSelected = player.getItemByID(Integer.parseInt(playerAnswer));
                        }
                    }
                    itemSelected.inspectItem(input,player);
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
                        player.recreateItemsMapWithIDs(player.categorizeByName());
                    }
                    else if(playerAnswer.equals("2")){
                        player.recreateItemsMapWithIDs(player.categoriesByPrice());
                    }
                    else if(playerAnswer.equals("3")){
                        player.recreateItemsMapWithIDs(player.categorizeByWeight());
                    }
                    else if(playerAnswer.equals("4")){
                        player.recreateItemsMapWithIDs(player.catergorizeByCategory());
                    }
                }
                else if (playerAnswer.equals("3")){
                    exitInventory = true;
                }
                else{
                    System.out.println("Enter valid input");
                    System.out.println();
                }
            }
            inspectPlayer();
            return;
        }
        else if(playerAnswer.equals("4")){
            mainDialogue();
            return;
        }
        else{
            System.out.println("Need to enter correct input");
            inspectPlayer();
            return;
        }
    }
}
