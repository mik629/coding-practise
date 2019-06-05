package deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck36 implements Deck {
    private final List<Card> cards;
    private final Random rnd = new Random();

    public Deck36() {
        this.cards = new ArrayList<>();

        for (Suit suit : Suit.values()) {
            for (int i = 2; i != 5 && i < 12; i++) {
                cards.add(new RegularCard(suit, i));
            }
        }
        Collections.shuffle(cards);
    }

    @Override
    public Card next() {
        return cards.remove(rnd.nextInt(cards.size()));
    }

    @Override
    public boolean isEmpty() {
        return cards.isEmpty();
    }
}
