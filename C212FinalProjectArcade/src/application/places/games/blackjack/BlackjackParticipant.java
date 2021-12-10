package application.places.games.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BlackjackParticipant {

    public static Random rand = new Random();

    protected static ArrayList<String> cards = new ArrayList<>(List.of("A", "A", "A", "A", "2", "2", "2", "2", "3", "3",
            "3", "3", "4", "4", "4", "4", "5", "5", "5", "5", "6", "6", "6", "6", "7", "7", "7", "7", "8", "8", "8", "8",
            "9", "9", "9", "9", "10", "10", "10", "10", "K", "K", "K", "K", "Q", "Q", "Q", "Q", "J", "J", "J", "J"));
    protected int[] handTotals;

    public void hit() {
        String newCard = cards.get(rand.nextInt(cards.size()));
        switch(newCard) {
            case "A":
                handTotals[0] += 1;
                handTotals[1] += 11; break;

            case "K":
            case "Q":
            case "J":
                handTotals[0] += 10;
                handTotals[1] += 10; break;
            default:
                handTotals[0] += Integer.parseInt(newCard);
                handTotals[1] += Integer.parseInt(newCard);
        }
        cards.remove(newCard);
    }

    public abstract int getBestTotal();
}
