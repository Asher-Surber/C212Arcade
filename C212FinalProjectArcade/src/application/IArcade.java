package application;

import application.models.User;
import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;
import application.places.games.GuessTheNumber;
import application.places.games.Trivia;

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
        allPlaces.add(l);
        allPlaces.add(s);
        allPlaces.add(i);
        allPlaces.add(g);
        allPlaces.add(t);
        //TODO add games
        return allPlaces;
    }
}
