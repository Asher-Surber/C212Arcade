package application.places;

import application.Arcade;
import application.IArcade;
import application.models.User;
import application.utils.ConsoleUtils;

public class Lobby extends Place{

    public Lobby(){
        this.placeName = "Lobby";
        this.entryFee = 0.00;
        this.isGame = false;
    }

    @Override
    public void onEnter(User user) {
        ConsoleUtils.printMenuToConsole("Welcome to the C212 Arcade! Your balance is: " + user.getBalance() +
                "\n", IArcade.getAllPlaces(), true);
    }
}
