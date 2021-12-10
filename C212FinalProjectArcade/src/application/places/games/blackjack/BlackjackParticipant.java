package application.places.games.blackjack;

import java.util.ArrayList;

public abstract class BlackjackParticipant {

    protected static ArrayList<String> cards;
    protected int[] handTotals;

    public void hit() {

    }

    public abstract int getBestTotal();
}
