import java.util.Scanner;

public class Merchant extends Character{

    Scanner input;
    Player playerInteractingWith;

    public Merchant(String name) {
        super(name);
        super.setBalance(100);
        stockMerchantInventory();
        input = new Scanner(System.in);
    }

    private void stockMerchantInventory(){
        for (int i = 0; i < 5; i++) {
            HealthPotion healthPotion = new HealthPotion();
           addItemToInventory(healthPotion);
        }

        for (int i = 0; i < 3; i++) {
            ManaPotion manaPotion = new ManaPotion();
            addItemToInventory(manaPotion);
        }
    }

    public void talkWith(Player withWhichPlayer){
        playerInteractingWith = withWhichPlayer;
        System.out.println("Hello there! Want to see my goods");
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print("Your Answer: ");
        String playerAnswer = playerInput();
        if(playerAnswer.equals("2") || playerAnswer.equals("no")){
            System.out.println("Ok then lad. See you around");
        }
        else if(playerAnswer.equals("1") || playerAnswer.equals("yes")){
            openShop();
        }
        else {
            System.out.println("I dont understand you lad. Come back some other time.");
        }

    }

    private void openShop() {
        Shop shop = new Shop(getItemList());
        System.out.println("Do you wish buy or sell?");
        System.out.println("1) Buy");
        System.out.println("2) Sell");
        System.out.println("3) Exit");
        String playerAnswer = playerInput();
        if(playerAnswer.equals("1") || playerAnswer.equals("buy")){
            shop.printInventoryWithID();
            Item itemSelected = shop.itemSelection(input);
            if(itemSelected==null){
                // ask to input new choice or exit
            }else{
                if(shop.enoughBalanceToPurchaseItem(playerInteractingWith.getBalance(),itemSelected)){
                    receiveBalance(shop.purchaseItem(playerInteractingWith,itemSelected));
                    removeItemFromInventory(itemSelected);
                }
                else{
                    // tell player not enough balance input new choice or exit
                }

            }
        }
        else if(playerAnswer.equals("2") || playerAnswer.equals("sell")){

        }
    }

    public String playerInput(){
        return input.nextLine().trim().
                toLowerCase().replace(" ","");
    }

}
