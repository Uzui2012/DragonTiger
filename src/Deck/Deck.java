package Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck
{
    private List<Card> cards;

    public Deck(){
        cards = new ArrayList<>();
        int rank = 1;
        for(int i = 0; i < 52; i=i+4){
            cards.add(new Card(Suit.Spade, rank));
            cards.add(new Card(Suit.Club, rank));
            cards.add(new Card(Suit.Diamond, rank));
            cards.add(new Card(Suit.Heart, rank));
            rank++;
            if(rank == 14){
                rank = 1;
            } 
        }
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public List<Card> getCards(){
        return cards;
    }

    public String toString(){
        String result = "";
        for(int i = 0; i < 52; i=i+4){
            result = result.concat("[" + cards.get(i).toString() + "], " + 
            "[" + cards.get(i+1).toString() + "], " + 
            "[" + cards.get(i+2).toString() + "], " + 
            "[" + cards.get(i+3).toString() + "], \n"
            );
        }
        result = result.substring(0, result.length()-3);
        return result;
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }
}
