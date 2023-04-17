public class Level {
    // TODO: review the difference of interface & abstract class; overload, override;; polymorphism

    // current game level
    int level;

    GameManager game;

    int count;

    // --------- Setters and Getters ----------
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level= level;
    }

    public GameManager getGame() {
        return game;
    }

    public void setGame(GameManager game) {
        this.game= game;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count= count;
    }

    // ---------- Methods ---------
    public Level(GameManager g) {
        game= g;
        count= 0;
    }

    // TODO change it to abstract method
    public boolean toHit(Player p) {
        return false;
    }

    public void countCards(int cardIdx) {
        System.out.println("Counting cards is not available for the current level");
    }
}

class Level1 extends Level {
    public Level1(GameManager g) {
        super(g);
        level= 1;
    }

    /** 50% chance to hit and 50% chance to stand */
    @Override
    public boolean toHit(Player p) {
        return Math.random() <= 0.50;
    }
}

class Level2 extends Level {
    public Level2(GameManager g) {
        super(g);
        level= 2;
    }

    /** Hit when points <= 17, stand when points > 17 */
    @Override
    public boolean toHit(Player p) {
        return p.getSum() <= 17;
    }
}

class Level3 extends Level {
    public Level3(GameManager g) {
        super(g);
        level= 3;
    }

    /** Different % of hit based on points */
    @Override
    public boolean toHit(Player p) {
        // Configuration for points from 12 to 20
        // TODO: Separate configuration in a property file
        double[] config= new double[] { 0.9, 0.8, 0.7, 0.6, 0.5, 0.4, 0.3, 0.2, 0.1 };
        if (p.getSum() <= 17) {
            return true;
        } else {
            double d= Math.random();
            int points= p.getSum();
            return points >= 12 && points <= 20 && d <= config[points - 12];
        }
    }
}

class Level4 extends Level {
    public Level4(GameManager g) {
        super(g);
        level= 4;
    }

    /** Count every card shown */
    @Override
    public void countCards(int cardId) {
        // for card 2, 3, 4, 5, 6
        if (cardId >= 1 && cardId < 6) count++ ;
        // for card 9, 10, J, Q, K
        else count-- ;
    }

    @Override
    public boolean toHit(Player p) {
        return p.getSum() > 11 && count < 0 || p.getSum() <= 11 && count >= 0;
    }
}
