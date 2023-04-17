
import java.util.ArrayList;

public class Player {
    // the player's index in the players array
    private int id;

    // the cards a player has get
    private ArrayList<Card> playerCards;

    // current cards' sum
    private int sum;

    // true: if the player has a Ace
    private boolean hasAce;

    enum PlayerState {
        NONE,
        BLACKJACK,
        HIT,
        STAND,
        BUST
    }

    private PlayerState state;

    // ---------- Getters and Setters ----------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id= id;
    }

    public ArrayList<Card> getCards() {
        return playerCards;
    }

    public void setCards(ArrayList<Card> cards) {
        playerCards= cards;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum= sum;
    }

    public boolean hasAce() {
        return hasAce;
    }

    public void hasAce(boolean b) {
        hasAce= b;
    }

    public PlayerState getState() {
        return state;
    }

    public void setState(PlayerState state) {
        this.state= state;
    }

    // ---------- Methods ----------
    public Player() {
        id= -1;
        playerCards= new ArrayList<>();
        sum= 0;
        hasAce= false;
        state= PlayerState.NONE;
    }

    /** The player gets a new card. */
    public void getNewCard(Card c, boolean b) {
        playerCards.add(c);
        if (c.getValue() == Card.FaceValue.ACE) {
            hasAce= true;
        }
        sum+= Card.faceValueToInt(c.getValue());
        updateState();
        if (b) display(c);
    }

    /** Check and update player's state. */
    public void updateState() {
        if (!hasAce && sum == 21 || hasAce && sum == 11) {
            state= PlayerState.BLACKJACK;
        } else if (sum > 21) {
            state= PlayerState.BUST;
        }
    }

    /** Print the card suit and face value in console
     *
     * @param p: the player
     * @param c: the card */
    public void display(Card c) {
        if (this instanceof HumanPlayer) {
            System.out.println(
                "Player " + getId() + " gets: " + c.getSuit().name() + " " + c.getValue().name());
        } else {
            System.out.println(
                "Dealer gets: " + c.getSuit().name() + " " + c.getValue().name());
        }
    }

}
