package DragonTiger;

import java.util.ArrayList;
import java.util.List;

public class Agent
{
    private DragonTiger dt;

    public Agent(){
        this.dt = new DragonTiger(8);
    }

    public double playOneThenFiveBet(double wallet){
        dt = new DragonTiger(8);
        List<Outcome> log = new ArrayList<>();
        //double wallet = 100;
        double bet = 0;
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        List<String> result = new ArrayList<>();
        Boolean flag = false;
        for(int i = 0; i < 120; i ++){
            String guess = "SKIP";
            Outcome prev1 = log.get(log.size()-1);
            Outcome prev2 = log.get(log.size()-2);
            Outcome prev3 = log.get(log.size()-3);
            Outcome prev4 = log.get(log.size()-4);
            Outcome prev5 = log.get(log.size()-5);
            if(!flag){
                if(prev1==prev2 && prev2!=prev3 &&prev3!=prev4 && prev1!=Outcome.TIE && prev2!=Outcome.TIE && prev3!=Outcome.TIE && prev4!=Outcome.TIE){
                    if(prev1 == Outcome.DRAGON){
                        //PREVIOUS CARD WAS DRAGON
                        guess = Outcome.TIGER.name();
                        bet = 1;
                    }else if(prev1 == Outcome.TIGER){
                        //PREVIOUS CARD WAS TIGER
                        guess = Outcome.DRAGON.name();
                        bet = 1;
                    }
                }
            }else{
                if(prev1 == Outcome.DRAGON){
                    //PREVIOUS CARD WAS DRAGON
                    guess = Outcome.TIGER.name();
                    bet = 5;
                }else if(prev1 == Outcome.TIGER){
                    //PREVIOUS CARD WAS TIGER
                    guess = Outcome.DRAGON.name();
                    bet = 5;
                    
                }
            }
            wallet -= bet;
            //
            Outcome hand = dt.playHand();
            log.add(hand);
            String outcome;
            if(guess.equals(hand.name())){
                outcome = "WIN";
                wallet += bet*2;
                bet = 0;
                //System.out.print(hand.name() + ", " + guess + ":     " + outcome + ", " + wallet + "\n");
                result.add(outcome);
            }else if(guess=="SKIP"){
                outcome = "SKIP";
                bet = 0;
            }else {
                outcome = "LOSS";
                if(hand.equals(Outcome.TIE)){
                    wallet += bet/2;
                    if(!flag){
                        flag = true;
                    }else{
                        flag = false;
                        bet = 0;
                    }
                }else{
                    if(!flag){
                        flag = true;
                    }else{
                        flag = false;
                        bet = 0;
                    }
                }

                
                result.add(outcome);
                if(wallet < 0){
                    break;
                }
            }
            System.out.print(hand.name() + ", " + guess + ":     " + outcome + ", " + wallet + ", " + bet + ", " + flag + "\n");
        }
        System.out.println(result.toString());
        System.out.println(wallet);
        return wallet;

    }

    public double playStickBet(double wallet, double betINC){
        dt = new DragonTiger(8);
        List<Outcome> log = new ArrayList<>();
        //double wallet = 100;
        double bet = 0;
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        log.add(dt.playHand());
        List<String> result = new ArrayList<>();
        int numLoss = 0;
        for(int i = 0; i < 120; i ++){
            //GUESS PREDICTION
            String guess;
            Outcome prev1 = log.get(log.size()-1);
            Outcome prev2 = log.get(log.size()-2);
            Outcome prev3 = log.get(log.size()-3);
            Outcome prev4 = log.get(log.size()-4);
            Outcome prev5 = log.get(log.size()-5);
            if((prev1==prev2 && prev1==prev3) && (prev1 != prev5)){
            //|| (prev1==Outcome.TIE && prev2==prev3 && prev3==prev4 && prev5==prev4)) {
                if(bet==0){
                    bet = betINC;
                }else{
                    bet = bet*2;
                }
                wallet-=bet;
                //System.out.print(bet + ", ");
                if(prev1 == Outcome.DRAGON){
                    //PREVIOUS CARD WAS DRAGON
                    guess = Outcome.TIGER.name();
                }else if(prev1 == Outcome.TIGER){
                    //PREVIOUS CARD WAS TIGER
                    guess = Outcome.DRAGON.name();
                }else{
                    //PREVIOUS CARD WAS A TIE
                    if(prev2 == Outcome.DRAGON){
                        guess = Outcome.TIGER.name();
                    }else if(prev2 == Outcome.TIGER){
                        guess = Outcome.DRAGON.name();
                    }else{
                        if(prev3 == Outcome.DRAGON){
                            guess = Outcome.TIGER.name();
                        }else if(prev3 == Outcome.TIGER){
                            guess = Outcome.DRAGON.name();
                        }else{
                            guess = "SKIP";
                        }
                    }                    
                }
            }else{
                guess = "SKIP";
            }
            //
            Outcome hand = dt.playHand();
            log.add(hand);
            String outcome;
            if(guess.equals(hand.name())){
                outcome = "WIN";
                wallet += bet*2;
                bet = 0;
                numLoss = 0;
                //System.out.print(hand.name() + ", " + guess + ":     " + outcome + ", " + wallet + "\n");
                result.add(outcome);
            }else if(guess=="SKIP"){
                outcome = "SKIP";
                bet = 0;
            }else {
                outcome = "LOSS";
                numLoss++;
                if(hand.equals(Outcome.TIE)){
                    wallet += bet/2;
                }   

                //System.out.print(hand.name() + ", " + guess + ":     " + outcome + ", " + wallet + "\n");
                result.add(outcome);
                if(wallet < 0){
                    break;
                }
            }
            System.out.print(hand.name() + ", " + guess + ":     " + outcome + ", " + wallet + "\n");
        }
        System.out.println(result.toString());
        System.out.println(wallet);
        return wallet;
    }
}
