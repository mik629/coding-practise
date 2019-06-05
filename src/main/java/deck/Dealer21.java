package deck;

import java.util.ArrayList;
import java.util.List;

public class Dealer21 implements Dealer {
    private final Deck deck;
    private final List<Hand> hands;

    public Dealer21(int players) {
        this.deck = new Deck36();
        this.hands = new ArrayList<>(players);

        for (int i = 0; i < players; i++) {
            hands.add(new Hand());
        }
    }

    @Override
    public List<Hand> dealAllHands() {
        for (Hand hand : hands) {
            while (hand.score() < 21 && !deck.isEmpty()) {
                hand.addCard(deck.next());
            }
        }
        return hands;
    }
}
