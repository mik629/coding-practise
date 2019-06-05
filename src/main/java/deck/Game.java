package deck;

import java.util.List;

public class Game {
    public static void main(String[] args) {
        boolean winnerExist = false;
        List<Hand> allHands = new Dealer21(6).dealAllHands();
        for (Hand hand : allHands) {
            if (hand.isWinner()) {
                System.out.println("We've got a winner!");
                winnerExist = true;
            }
        }
        if (!winnerExist) {
            System.out.println("No winners today :(");
        }
    }
}
