import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player = new Player("Brian");
        Merchant merchant = new Merchant("Merchant");

        for (int i = 0; i < player.getItemList().size(); i++) {
            List<Item> items = player.categoriesByPrice();
            System.out.println(items.get(i));
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
