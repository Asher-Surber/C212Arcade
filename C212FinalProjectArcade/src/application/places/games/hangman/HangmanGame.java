package application.places.games.hangman;

import application.models.User;
import application.places.games.Game;
import application.utils.ConsoleUtils;
import application.utils.http.HttpUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        System.out.print("Welcome to Hangman! You will be shown a blurred-out word, and you have 6 tries to guess\neither a letter or the word.\n");
        System.out.println("If you guess the word, you'll win $15.00! Good luck!");

        try{
            List<Character> lex = getValidLexicon();
            String word = HttpUtils.getRandomHangmanWord();
            List<Character> guesses = new ArrayList<>();
            getBlurredWord(guesses, word);
            String guess;
            do{
                guess = ConsoleUtils.readLineFromConsole();
                if(guess.length() == 1){
                    if(word.contains(guess)){
                        char lGuess = guess.charAt(0);
                    }
                }
            }
            while(guesses.size() < 6 && !guess.equalsIgnoreCase(word));
        }
        catch(IOException e){
            System.out.println("Problem getting word");
        }
    }
}
