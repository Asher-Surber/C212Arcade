package edu.iu.c212.places;

import edu.iu.c212.models.User;
import edu.iu.c212.utils.ConsoleUtils;

public class Lobby extends Place{

    public Lobby(){
        this.placeName = "Lobby";
        this.entryFee = 0.00;
        this.isGame = false;
    }

    @Override
    void onEnter(User user) {
        ConsoleUtils.printMenuToConsole("Welcome to the C212 Arcade! Your balance is: " + user.getBalance() +
                "\n", arcade.getAllPlaces(), true);
    }
}
