package application.places.games.hangman;

import application.models.User;
import application.places.games.Game;

import java.util.ArrayList;
import java.util.List;

public class HangmanGame extends Game implements IHangmanGame {

    public HangmanGame(){
        this.placeName = "Hangman";
        this.entryFee = 5.00;
        this.isGame = true;
    }

    @Override
    public String getBlurredWord(List<Character> guesses, String word) {
        String blurredWord = "";
        for(int i = 0; i < word.length(); i++){
            char l = word.charAt(i);
            if (!guesses.contains(l)){
                blurredWord = word.replace(l,'*');
            }
        }
        return blurredWord;
    }

    @Override
    public List<Character> getValidLexicon() {
        ArrayList<Character> lex = new ArrayList<>();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < alpha.length(); i++){
            char l = alpha.charAt(i);
            lex.add(l);
        }
        return lex;
    }

    @Override
    protected void onEnter(User user) {

    }
}
