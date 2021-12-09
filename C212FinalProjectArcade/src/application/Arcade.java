package application;

import application.models.Item;
import application.models.User;
import application.places.Inventory;
import application.places.Lobby;
import application.places.Place;
import application.places.Store;
import application.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arcade implements IArcade{

    private User currentUser;
    private List<User> allUsers;
    private List<Place> allPlaces;

    public Arcade(){
        this.currentUser = getUserOnArcadeEntry();
        this.allUsers = getUserSaveDataFromFile();
        this.allPlaces = getAllPlaces();
        transitionArcadeState("Lobby");
    }

    @Override
    public List<User> getUserSaveDataFromFile() {
        List<User> userList = null;
        try{
            userList = FileUtils.getUserDataFromFile();
        }
        catch(Exception e){
            System.out.println("File error");
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
            System.out.println("File error");
            System.exit(0);
        }
    }

    @Override
    public void transitionArcadeState(String newPlaceNameToGoTo) {
        Place newPlace = null;
        for(Place place : allPlaces){
            if(place.getPlaceName().equals(newPlaceNameToGoTo)){
                newPlace = place;
            }
        }
        if (currentUser.getBalance() >= newPlace.getEntryFee()){
            currentUser.setBalance(currentUser.getBalance() - newPlace.getEntryFee());
            try{
                FileUtils.writeUserDataToFile(allUsers);
            }
            catch(Exception e){
                System.out.println("File error");
                System.exit(0);
            }
            switch(newPlace.getPlaceName()){
                case "Lobby":
                    Lobby l = new Lobby();
                    l.onEnter(currentUser); break;
                case "Inventory":
                    Inventory i = new Inventory();
                    i.onEnter(currentUser); break;
                case "Store":
                    Store s = new Store();
                    s.onEnter(currentUser); break;
                //TODO add games
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
            System.out.println("File error");
            System.exit(0);
        }
        System.out.println("Welcome to the C212 Arcade, " + username + "!");
        return newUser;
    }


    @Override
    public List<Place> getAllPlaces() {
        ArrayList<Place> allPlaces = new ArrayList<>();
        allPlaces.add(new Lobby());
        allPlaces.add(new Store());
        allPlaces.add(new Inventory());
        //TODO add games
        return allPlaces;
    }
}