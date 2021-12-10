package application.places;

import application.Arcade;
import application.models.User;

public abstract class Place {

    public static Arcade arcade;
    protected String placeName;
    //Arcade arcade;
    protected double entryFee;
    protected boolean isGame;

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

//    public Arcade getArcade() {
//        return arcade;
//    }

    public static void setArcade(Arcade myArcade) {
        arcade = myArcade;
    }
}
