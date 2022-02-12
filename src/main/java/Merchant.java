import java.util.Scanner;

public class Merchant extends Character{

    public Merchant(String name) {
        super(name);
        stockMerchantInventory();
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
        Scanner input = new Scanner(System.in);
        System.out.println("1) Yes");
        System.out.println("2) No");
        System.out.print("Your Answer: ");
        String playerAnswer = input.nextLine().trim().
                toLowerCase().replace(" ","");
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
        Shop merchantShop = new Shop(getItemList());
    }

}
