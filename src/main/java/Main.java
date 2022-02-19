import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Player player = new Player("Brian");
        Merchant merchant = new Merchant("Merchant");

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
