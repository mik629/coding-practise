package deck;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
        cards.add(card);
    }

    public Integer score() {
        return cards.stream()
                .mapToInt(Card::getValue)
                .sum();
    }

    public boolean isWinner() {
        return score() == 21;
    }
}
