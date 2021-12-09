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

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(double entryFee) {
        this.entryFee = entryFee;
    }

    public boolean isGame() {
        return isGame;
    }

    public void setGame(boolean game) {
        isGame = game;
    }
}
