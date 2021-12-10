package application.places;

import application.models.Item;
import application.models.User;

import java.util.ArrayList;

public class Inventory extends Place{

    public Inventory(){
        this.placeName = "Inventory";
        this.entryFee = 0.00;
        this.isGame = false;
    }

    @Override
    public void onEnter(User user) {
        System.out.println("Hi, " + user.getUsername() + "! This is your inventory:");
        ArrayList<Item> inventory;
        inventory = (ArrayList<Item>) user.getInventory();
        double netWorth = user.getBalance();
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i));
            netWorth += inventory.get(i).getValue();
        }
        System.out.println("Your total net worth is: $" + netWorth);
        if (inventory.size() == 3){
            System.out.println("Remember, you can only have up to 3 items in your inventory! Sell one by going to the store.");
        }
        arcade.transitionArcadeState("Lobby");
    }
}
