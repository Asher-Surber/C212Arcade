package application.places.games;

import application.models.User;
import application.utils.ConsoleUtils;

import java.util.Random;

public class GuessTheNumber extends Game{

    public GuessTheNumber(){
        this.placeName = "Guess the Number";
        this.entryFee = 5.00;
        this.isGame = true;
    }


    @Override
    public void onEnter(User user) {
        Random rand = new Random();
        System.out.print("Welcome to Guess the Number! You have 5 tries to guess the random number between 0 and 100!\nGood luck!\n");
        int num = rand.nextInt(101);
        int guesses = 5;
        int ans = -1;
        while(guesses > 0 && ans != num){
            System.out.println("What's your guess?");
            ans = ConsoleUtils.readIntegerLineFromConsoleOrElseComplainAndRetry(number -> number >= 0 && number <= 100, "You must enter a number between 1 and 100 (inclusive)");
            if(ans == num){
                System.out.println("You got it! Congratulations! You've won $10.00. Returning to Lobby...");
                user.setBalance(user.getBalance() + 10.00);
                arcade.saveUsersToFile();
                arcade.transitionArcadeState("Lobby");
            }
            else if (ans > num){
                System.out.println("Sorry, that's not it! Try a lower number.");
                guesses--;
            }
            else if(ans < num){
                System.out.println("Sorry, that's not it! Try a higher number.");
                guesses--;
            }
        }
        System.out.print("Sorry, you didn't get it! The number was " + num + ".\nCome back and try again another time!\n");
        System.out.println("Returning to Lobby...");
        arcade.transitionArcadeState("Lobby");
    }
}
