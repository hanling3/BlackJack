
public class Card {
    enum Suit {
        CLUB,
        DIAMOND,
        HEART,
        SPADE,
    }

    enum FaceValue {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
        JACK, QUEEN, KING, ACE
    }

    enum SpecialValue {
        NA,
        JOKER
    }

    // --------- Fields --------
    private FaceValue value;

    private Suit suit;

    private SpecialValue special;

    // -------- Setters and Getters ----------

    public FaceValue getValue() {
        return value;
    }

    public void setValue(FaceValue value) {
        this.value= value;
    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit= suit;
    }

    public SpecialValue isSpecial() {
        return special;
    }

    public void setSpecial(SpecialValue s) {
        special= s;
    }

    // --------- Methods --------
    public Card(Suit s, FaceValue f) {
        suit= s;
        value= f;
    }

    public static int faceValueToInt(FaceValue fv) {
        switch (fv) {
        case ACE:
            return 1;
        case TWO:
            return 2;
        case THREE:
            return 3;
        case FOUR:
            return 4;
        case FIVE:
            return 5;
        case SIX:
            return 6;
        case SEVEN:
            return 7;
        case EIGHT:
            return 8;
        case NINE:
            return 9;
        case JACK:
            return 10;
        case QUEEN:
            return 10;
        case KING:
            return 10;
        }
        return -1;
    }

}
