
public class Decks {
    private int numOfDecks;

    private int numOfCards;

//    private Card[] oneDeck;

    private Card[] cards;

    private int currCardPos;

    // ---------- Getters and Setters ----------

    public int getNumOfDecks() {
        return numOfDecks;
    }

    public void setNumOfDecks(int numOfDecks) {
        this.numOfDecks= numOfDecks;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards= cards;
    }

    // ---------- Methods ----------

    public Decks(int numOfDecks) {
//        oneDeck= new Card[52];
        this.numOfDecks= numOfDecks;
        numOfCards= 52 * numOfDecks;
        cards= new Card[numOfCards];
        int index= 0;
        for (Card.Suit s : Card.Suit.values()) {
            for (Card.FaceValue fv : Card.FaceValue.values()) {
                Card c= new Card(s, fv);
//                oneDeck[index]= c;
                for (int j= 0; j < numOfDecks; j++ ) {
                    cards[index + j * 52]= c;
                }
                index++ ;
            }
        }

    }

    public void shuffle() {
        for (int i= 0; i < numOfCards; i++ ) {
            int randomIdx= (int) (Math.random() * (numOfCards - i) + i);
            Card tmp= cards[i];
            cards[i]= cards[randomIdx];
            cards[randomIdx]= tmp;
//            System.out.println("Debug shuffle: " + numOfCards + " " + i + " " + randomIdx);
        }
    }

    /** Distribute a card
     *
     * @return the id of the card */
    public Card deal() {
        return cards[currCardPos++ ];
    }

}
