import java.util.Scanner;

import DragonTiger.Agent;
import DragonTiger.DragonTiger;

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
        double payout = 500;
        double max = 500;
        for(int i = 0; i < 5000000; i++){
            payout = agent.playOneThenFiveBet(payout);
            if(payout<0){
                break;
            }
            if( payout > max){
                max = payout;
            }
        }
        System.out.println("IN FOR: " + 50 + "\nOUT FOR: " + (payout));
        System.out.println("MAX: " + max);
    }
}