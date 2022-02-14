import java.nio.file.LinkPermission;
import java.util.Scanner;

public class Merchant extends Character{

    Scanner input;

    public Merchant(String name) {
        super(name);
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

    public void talk(){
        System.out.println("Hello there! Want to see my goods");
        String playerAnswer = yesOrNoResponse();
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

    private String yesOrNoResponse() {
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print("Your Answer: ");
        String playerAnswer = input.nextLine().trim().
                toLowerCase().replace(" ","");
        return playerAnswer;
    }

    private void openShop() {
        Shop merchantShop = new Shop(getItemList());
        System.out.println("Do you wish buy or sell?");
        String playerAnswer = yesOrNoResponse();
        if(playerAnswer.equals("1") || playerAnswer.equals("yes")){
            merchantShop.printInventoryWithID();
            merchantShop.itemSelection(input);
        }
        else if(playerAnswer.equals("2") || playerAnswer.equals("no")){

        }
    }

}
