package edu.iu.c212;

import edu.iu.c212.models.User;
import edu.iu.c212.places.Place;

import java.util.List;

public interface IArcade {

    List<User> getUserSaveDataFromFile();
    void saveUsersToFile();
    void transitionArcadeState(String newPlaceNameToGoTo);
    User getUserOnArcadeEntry();
    List<Place> getAllPlaces();
}
