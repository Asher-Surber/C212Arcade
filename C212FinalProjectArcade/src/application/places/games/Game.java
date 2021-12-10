package application.places.games;

import application.models.User;
import application.places.Place;

public abstract class Game extends Place {

    public abstract void onEnter(User user);
}
