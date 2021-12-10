package application.places.games;

import application.models.User;
import application.utils.ConsoleUtils;
import application.utils.http.HttpUtils;
import application.utils.http.TriviaQuestion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Trivia extends Game{

    public Trivia(){
        this.placeName = "Trivia";
        this.entryFee = 0.00;
        this.isGame = true;
    }
    @Override
    public void onEnter(User user) {
        Random rand = new Random();
        System.out.print("Welcome to C212 Trivia? How much do YOU know about random things?\nYou'll get $2 for every " +
                "question you get correct. There are 5 questions total. Good luck!\n");
        try{
            List<TriviaQuestion> questions = HttpUtils.getTriviaQuestions(5);
            int ctr = 1;
            int correct = 0;
            int totalWon = 0;

            for(TriviaQuestion q : questions){
                System.out.println("You're on Question " + ctr +". Ready?");
                try {
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    System.out.println("Sleep error");
                }
                String question = q.getQuestion();
                int correctPos = rand.nextInt(4);
                List<String> answers = new LinkedList<>();
                answers.addAll(q.getIncorrectAnswers());
                answers.add(correctPos, q.getCorrectAnswer());

                String userAns = ConsoleUtils.printMenuToConsole(question, answers, true);
                assert userAns != null;
                if(userAns.equals(q.getCorrectAnswer())){
                    System.out.println("That's correct! You've won $2.");
                    correct++;
                    totalWon += 2;
                    ctr++;
                }
                else{
                    System.out.println("Sorry, that's incorrect! The correct answer was " + q.getCorrectAnswer());
                    ctr++;
                }
            }
            if(correct >= 3){
                System.out.println("Nice, you got " + correct + " questions right! You've won a total of $" + totalWon);
            }
            else{
                System.out.println("Aw, nice try. You got " + correct + " questions right. You've won a total of $" + totalWon);
            }
            user.setBalance(user.getBalance() + totalWon);
            arcade.saveUsersToFile();
            System.out.println("Returning to Lobby...");
            arcade.transitionArcadeState("Lobby");
        }
        catch(IOException e){
            System.out.println("Problem getting trivia questions");
            e.getStackTrace();
        }
    }
}
