import java.util.Scanner;

public class Driver
{
    public static void playerPlays(DragonTiger dt){
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < 150; i ++){
            System.out.println("Player Guess(DRAGON, TIGER, or TIE): ");
            String guess = scanner.nextLine();
            String hand = dt.playHand().name();
            String outcome;
            if(guess.equals(hand)){
                outcome = "WIN";
            }else {
                outcome = "LOSS";
            }
            System.out.print(hand + ", " + guess + "\n" + outcome + "\n");
        }
        scanner.close();
    }
    public static void main(String[] args) {
        Agent agent = new Agent();
        double payout = 150;
        for(int i = 0; i < 10; i++){
            payout = agent.play(payout, 1);
            if(payout<50){
                break;
            }
        }
        System.out.println("IN FOR: " + 50 + "\nOUT FOR: " + (payout));
    }
}