package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Shoe
{
    private List<Card> cards;
    
    public Shoe(List<Deck> decks) {
        this.cards = new ArrayList<>();
        for (Deck deck : decks) {
            for(int i = 0; i < 52; i++) {
                cards.add(deck.getCard(i));
            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public Card takeCard(){
        Card result = getCard(0);
        this.cards.remove(0);
        return result;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < cards.size(); i=i+4){
            result = result.concat("[" + cards.get(i).toString() + "], " + 
            "[" + cards.get(i+1).toString() + "], " + 
            "[" + cards.get(i+2).toString() + "], " + 
            "[" + cards.get(i+3).toString() + "], \n"
            );
        }
        result = result.substring(0, result.length()-3);
        return result;
    }
}
