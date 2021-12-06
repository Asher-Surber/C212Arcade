package edu.iu.c212.places;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.User;

import java.util.ArrayList;

public class Inventory extends Place{

    @Override
    void onEnter(User user) {
        System.out.println("Hi, " + user.getUsername() + "! This is your inventory:");
        ArrayList<Item> inventory = new ArrayList<>();
        inventory = (ArrayList<Item>) user.getInventory();
        double netWorth = user.getBalance();
        for (int i = 0; i < inventory.size(); i++){
            System.out.println(inventory.get(i).toString());
            netWorth += inventory.get(i).getValue();
        }
        System.out.println("Your total net worth is: $" + netWorth);
        if (inventory.size() == 3){
            System.out.println("Remember, you can only have up to 3 items in your inventory! Sell one by going to the store.");
        }
        arcade.transitionArcadeState("Lobby");
    }
}
