package application.places.games.blackjack;

import application.Arcade;
import application.models.User;
import application.places.games.Game;

public class BlackjackGame extends Game {

    public BlackjackGame(){
        this.placeName = "Blackjack";
        this.entryFee = 20.00;
        this.isGame = true;
    }

    @Override
    public void onEnter(User user) {
        BlackjackPlayer p = new BlackjackPlayer();
        BlackjackDealer d = new BlackjackDealer();
    }
}
