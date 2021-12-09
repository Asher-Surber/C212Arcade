package application;

import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;

public class ArcadeMain {
    public static void main(String[] args) {
        Arcade arcade = new Arcade();
        Place.setArcade(arcade);
    }
}
