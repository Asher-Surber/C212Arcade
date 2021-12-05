package edu.iu.c212;

import edu.iu.c212.models.User;
import edu.iu.c212.places.Place;

import java.util.List;

public class Arcade implements IArcade{
    @Override
    public List<User> getUserSaveDataFromFile() {
        return null;
    }

    @Override
    public void saveUsersToFile() {

    }

    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) {

    }

    @Override
    public User getUserOnArcadeEntry() {
        return null;
    }

    @Override
    public List<Place> getAllPlaces() {
        return null;
    }
}
