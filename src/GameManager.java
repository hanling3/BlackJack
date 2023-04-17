import java.util.Scanner;

public class GameManager {

    private HumanPlayer[] players;

    private Player dealer;

    private int numOfDecks;

    private int numOfPlayers;

    private Decks cards;

    private StringBuilder winners;

    // TODO use bit operation to save space
    private boolean dealerBJ;

    private boolean playerBJ;

    private boolean gameEnds;

    // ---------- Getters and Setters ----------

    public Player[] getPlayers() {
        return players;
    }

    public int getNumOfDecks() {
        return numOfDecks;
    }

    // ---------- Methods ----------
    public static void main(String[] args) {
        GameManager game= new GameManager();
        game.getInput();
        game.start();
        if (!game.gameEnds) {
            game.humanPlayersContinue();
        }
        if (!game.gameEnds) {
            game.dealerContinue();
        }
        if (!game.gameEnds) {
            game.comparePoints();
        }
    }

    public GameManager() {
        winners= new StringBuilder();
        playerBJ= false;
        dealerBJ= false;
        gameEnds= false;
    }

    // Get the user's inputs
    public void getInput() {
        System.out.println("Please enter in two seperate lineS: " + '\n' +
            "(1)the number of decks you want to use " + '\n' +
            "(2)the number of players for the game");
        Scanner in= new Scanner(System.in);
        numOfDecks= in.nextInt();
        numOfPlayers= in.nextInt();
        cards= new Decks(numOfDecks);
        cards.shuffle();
        players= new HumanPlayer[numOfPlayers];
        for (int i= 0; i < numOfPlayers; i++ ) {
            HumanPlayer p= new HumanPlayer();
            players[i]= p;
            p.setId(i + 1);
        }
        dealer= new Player();
    }

    /** Every player gets an initial hand of two cards. Dealer gets two cards including one hole
     * card. */
    public void start() {
        System.out.println("Game Starts");
        for (int i= 0; i < numOfPlayers; i++ ) {
            deal(players[i], true);
        }
        for (int i= 0; i < numOfPlayers; i++ ) {
            deal(players[i], true);
        }
        deal(dealer, true);
        deal(dealer, false);
    }

    /** Human players get new cards until they are finished */
    public void humanPlayersContinue() {
        int numOfFinished= 0;
        while (numOfFinished != numOfPlayers) {
            for (int i= 0; i < numOfPlayers; i++ ) {
                if (players[i].getState().equals(Player.PlayerState.HIT) ||
                    players[i].getState().equals(Player.PlayerState.NONE)) {
                    if (players[i].toHit()) {
                        deal(players[i], true);
                        Player.PlayerState s= players[i].getState();
                        if (s.equals(Player.PlayerState.BUST) ||
                            s.equals(Player.PlayerState.BLACKJACK)) {
                            numOfFinished++ ;
                        }
                    } else {
                        numOfFinished++ ;
                    }
                }
            }
        }
    }

    /** Dealer gets new cards until its sum >= 17 */
    public void dealerContinue() {
        System.out.print("For the hole card, ");
        dealer.display(dealer.getCards().get(1));
        // TODO: change while loop condition to a method in Dealer class
        while (dealer.getSum() < 17) {
            deal(dealer, true);
        }
    }

    /** Compare players' and dealer's points */
    public void comparePoints() {
        boolean tie= false;
        int dealerPoint= dealer.getSum();
        for (int i= 0; i < numOfPlayers; i++ ) {
            if (players[i] != null) {
                if (players[i].getSum() == dealerPoint) {
                    tie= true;
                } else if (players[i].getSum() > dealerPoint) {
                    System.out.println("Players win");
                    return;
                }
            }
        }
        if (tie) {
            System.out.println("Tie");
            return;
        }
        System.out.println("Dealer wins");
    }

    /** Distribute a card to a player p.
     *
     * @param p: player
     * @param b: whether to display the card in console */
    public void deal(Player p, boolean b) {
        Card card= cards.deal();
        p.getNewCard(card, b);
    }

    /** Check if any player owns blackjack. */
    public void checkGameEnds() {
        for (HumanPlayer p : players) {
            if (p.getState().equals(Player.PlayerState.BLACKJACK)) {
                playerBJ= true;
                winners.append(p.getId());
            }
        }
        if (dealer.getState().equals(Player.PlayerState.BLACKJACK)) {
            dealerBJ= true;
        }
        if (!playerBJ && !dealerBJ) { gameEnds= false; }
        System.out.println(" ");
        if (playerBJ && dealerBJ) {
            System.out.println("Tie");
        } else if (dealerBJ) {
            System.out.println("Dealer wins");
        } else {
            System.out.println("Player " + winners.toString() + " win");
        }
        gameEnds= true;
    }

}
