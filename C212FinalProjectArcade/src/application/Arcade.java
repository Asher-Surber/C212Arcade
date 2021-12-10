package application;

import application.models.Item;
import application.models.User;
import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;
import application.places.games.GuessTheNumber;
import application.places.games.Trivia;
import application.utils.FileUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arcade implements IArcade{

    private User currentUser;
    private List<User> allUsers;
    private List<Place> allPlaces;

    public Arcade(){
        this.allUsers = getUserSaveDataFromFile();
        this.currentUser = getUserOnArcadeEntry();
        this.allPlaces = IArcade.getAllPlaces();
        Place.arcade = this;
        transitionArcadeState("Lobby");
    }

    @Override
    public List<User> getUserSaveDataFromFile() {
        List<User> userList = new ArrayList<>();
        try{
            userList = FileUtils.getUserDataFromFile();
        }
        catch(Exception e){
            //System.out.println("File error");
            e.printStackTrace(System.out);
            System.exit(0);
        }
        return userList;
    }

    @Override
    public void saveUsersToFile() {
        try{
            FileUtils.writeUserDataToFile(allUsers);
        }
        catch(Exception e){
            System.out.println("File error Arcade:50");
            System.exit(0);
        }
    }

    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) {
        Place newPlace = null;
        for(Place place : allPlaces){
            if(place.getPlaceName().equals(newPlaceNameToGoTo)){
                newPlace = place;
                break;
            }
        }
        assert newPlace != null;
        if (currentUser.getBalance() >= newPlace.getEntryFee()){
            currentUser.setBalance(currentUser.getBalance() - newPlace.getEntryFee());
            try{
                FileUtils.writeUserDataToFile(allUsers);
                switch(newPlaceNameToGoTo){
                    case "Lobby":
                        Lobby l = new Lobby();
                        l.onEnter(currentUser); break;
                    case "Inventory":
                        Inventory i = new Inventory();
                        i.onEnter(currentUser); break;
                    case "Store":
                        Store s = new Store();
                        s.onEnter(currentUser); break;
                    case "Guess the Number":
                        GuessTheNumber g = new GuessTheNumber();
                        g.onEnter(currentUser); break;
                    case "Trivia":
                        Trivia t = new Trivia();
                        t.onEnter(currentUser);
                    //TODO add games
                }
            }
            catch(IOException e){
                System.out.println("File error Arcade:69");
                e.printStackTrace();
                System.exit(0);
            }
        }
        else{
            System.out.println("You don't have enough money to go there!");
            Lobby l = new Lobby();
            l.onEnter(currentUser);
        }
    }

    @Override
    public User getUserOnArcadeEntry() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter your username ('|' not allowed): ");
        String username = sc.next();
        while(username.contains("|")){
            System.out.print("Illegal character '|'. Please enter a different username: ");
            username = sc.next();
        }
        for(User user : allUsers){
            if(user.getUsername().equals(username)){
                System.out.println("Hi, " + username +"! Welcome back to the C212 Arcade!");
                return user;
            }
        }
        User newUser = new User(username, 0.00, new ArrayList<Item>());
        allUsers.add(newUser);
        try{
            FileUtils.writeUserDataToFile(allUsers);
        }
        catch(Exception e){
            System.out.println("File error Arcade:113");
            System.exit(0);
        }
        System.out.println("Welcome to the C212 Arcade, " + username + "!");
        return newUser;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public List<User> getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(List<User> allUsers) {
        this.allUsers = allUsers;
    }

    public void setAllPlaces(List<Place> allPlaces) {
        this.allPlaces = allPlaces;
    }
}
