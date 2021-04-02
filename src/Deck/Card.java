package Deck;

public class Card
{
    private Suit suit;
    private int rank;

    public Card(Suit suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getRank(){
        return this.rank;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public String toString() {
        return this.suit.name() + ", " + String.valueOf(this.rank);        
    }
}
