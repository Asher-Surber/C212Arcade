package application;

import application.models.User;
import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;

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
        allPlaces.add(l);
        allPlaces.add(s);
        allPlaces.add(i);
        //TODO add games
        return allPlaces;
    }
}
