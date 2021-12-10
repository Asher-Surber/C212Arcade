package application.places.games;

import application.models.User;

public class GuessTheNumber extends Game{

    public GuessTheNumber(){
        this.placeName = "Guess the Number";
        this.entryFee = 5.00;
        this.isGame = true;
    }

    @Override
    public void onEnter(User user){
        
    }
}
