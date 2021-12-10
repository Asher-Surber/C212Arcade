package application.places.games.hangman;

import java.util.List;

public interface IHangmanGame {

    String getBlurredWord(List<Character> guesses, String word);
    List<Character> getValidLexicon();
}
