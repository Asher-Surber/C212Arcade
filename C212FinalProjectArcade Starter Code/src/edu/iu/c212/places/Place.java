package edu.iu.c212.places;

import edu.iu.c212.Arcade;
import edu.iu.c212.models.User;

public abstract class Place {

    String placeName;
    Arcade arcade;
    double entryFee;
    boolean isGame;

    abstract void onEnter(User user);

    @Override
    public String toString(){
        return placeName + "- $" + entryFee + ", Game? " + isGame;
    }
}
