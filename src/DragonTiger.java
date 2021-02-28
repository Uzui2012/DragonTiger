import java.util.ArrayList;
import java.util.List;

public class DragonTiger
{
    private Shoe shoe;

    public DragonTiger(int numDecks){
        List<Deck> decks = new ArrayList<>();
        for(int i = 0; i < numDecks; i++){
            decks.add(new Deck());
        }
        this.shoe = new Shoe(decks);
        this.shoe.shuffle();
        this.shoe.shuffle();
    }

    public Outcome playHand(){
        Card dragon = this.shoe.takeCard();
        Card tiger = this.shoe.takeCard();
        if(dragon.getRank() == tiger.getRank()){
            return Outcome.TIE;
        }else if(dragon.getRank() > tiger.getRank()){
            return Outcome.DRAGON;
        }else{
            return Outcome.TIGER;
        }
    }
}
