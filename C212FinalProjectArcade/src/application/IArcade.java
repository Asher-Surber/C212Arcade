package application;

import application.models.User;
import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;
import application.places.games.GuessTheNumber;
import application.places.games.Trivia;
import application.places.games.blackjack.BlackjackGame;
import application.places.games.hangman.HangmanGame;

import java.util.ArrayList;
import java.util.List;

public interface IArcade {

    List<User> getUserSaveDataFromFile();
    void saveUsersToFile();
    void transitionArcadeState(String newPlaceNameToGoTo);
    User getUserOnArcadeEntry();

    static List<Place> getAllPlaces() {
        List<Place> allPlaces = new ArrayList<>();
        Lobby l = new Lobby();
        Store s = new Store();
        Inventory i = new Inventory();
        GuessTheNumber g = new GuessTheNumber();
        Trivia t = new Trivia();
        HangmanGame h = new HangmanGame();
        BlackjackGame b = new BlackjackGame();
        allPlaces.add(l);
        allPlaces.add(s);
        allPlaces.add(i);
        allPlaces.add(g);
        allPlaces.add(t);
        allPlaces.add(h);
        allPlaces.add(b);
        return allPlaces;
    }
}
