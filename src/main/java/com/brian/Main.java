package com.brian;

import com.brian.characters.Merchant;
import com.brian.characters.Player;
import com.brian.items.Item;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player = new Player("Brian");
        Merchant merchant = new Merchant("com.brian.characters.Merchant");

        List<Item> itemsByPrice = player.categoriesByPrice();
        for (int i = 0; i < player.getItemList().size(); i++) {
            System.out.println(itemsByPrice.get(i));
        }

        System.out.println();
        System.out.println();

        List<Item> itemsByName = player.categorizeByName();
        for (int i = 0; i < player.getItemList().size(); i++) {
            System.out.println(itemsByName.get(i));
        }

        boolean isValidAnswer = false;
        while (!isValidAnswer){
            System.out.println("1) Inspect Player");
            System.out.println("2) Talk To Merchant");
            System.out.print("Your Choice: ");
            String playerAnswer = input.nextLine().replace(" ", "");
            if(playerAnswer.equals("1")){
                // check inventory
                isValidAnswer = true;
                player.inspectPlayer();
            }
            else if(playerAnswer.equals("2")){
                isValidAnswer = true;
                merchant.talkWith(player);
            }
            else{
                System.out.println("Input A Valid Choice");
            }
        }
    }
}
