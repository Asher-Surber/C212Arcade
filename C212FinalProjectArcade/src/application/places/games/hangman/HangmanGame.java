package application.places.games.hangman;

import application.models.User;
import application.places.games.Game;

import java.util.List;

public class HangmanGame extends Game implements IHangmanGame {

    public HangmanGame(){
        this.placeName = "Hangman";
        this.entryFee = 5.00;
        this.isGame = true;
    }

    @Override
    public String getBlurredWord(List<Character> guesses, String word) {
        return null;
    }

    @Override
    public List<Character> getValidLexicon() {
        return null;
    }

    @Override
    protected void onEnter(User user) {

    }
}
