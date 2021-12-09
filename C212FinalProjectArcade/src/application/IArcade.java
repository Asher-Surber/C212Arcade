package application;

import application.models.User;
import application.places.Place;

import java.util.List;

public interface IArcade {

    List<User> getUserSaveDataFromFile();
    void saveUsersToFile();
    void transitionArcadeState(String newPlaceNameToGoTo);
    User getUserOnArcadeEntry();
    List<Place> getAllPlaces();
}
