package deck;

public class RegularCard implements Card {
    private final Suit suit;
    private final Integer value;

    public RegularCard(Suit suit, Integer value) {
        this.suit = suit;
        this.value = value;
    }


    @Override
    public Suit getSuit() {
        return suit;
    }

    @Override
    public Integer getValue() {
        return value;
    }
}
