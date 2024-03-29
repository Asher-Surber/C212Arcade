package application.places;

import application.models.Item;
import application.models.User;
import application.utils.ConsoleUtils;

import java.util.*;

public class Store extends Place{

    enum StoreActions{
        BUY, SELL, LEAVE;

        @Override
        public String toString(){
            return this.name().toLowerCase();
        }
    }

    StoreActions actions;

    public Store(){
        this.placeName = "Store";
        this.entryFee = 0.00;
        this.isGame = false;
    }

    @Override
    public void onEnter(User user) {
        ArrayList<StoreActions> actionList = new ArrayList<>();
        actionList.add(StoreActions.BUY);
        actionList.add(StoreActions.SELL);
        actionList.add(StoreActions.LEAVE);
        StoreActions action = ConsoleUtils.printMenuToConsole(" Would you like to buy, sell, or leave?", actionList, true);
        switch (Objects.requireNonNull(action)) {
            case BUY:
                buyHandler(user); break;
            case SELL:
                sellHandler(user); break;
            case LEAVE:
                arcade.transitionArcadeState("Lobby"); break;
        }
    }

    void buyHandler(User user){
        ArrayList<Item> itemList = new ArrayList<>();
        Collections.addAll(itemList, Item.values());
        Item j = ConsoleUtils.printMenuToConsole("What would you like to buy?", itemList, true);
        assert j != null;
        if (user.getBalance() < j.getValue()){
            System.out.println("You don't have enough money for this item!");
            onEnter(user);
        }
        else if (user.getInventory().size() == 3){
            System.out.println("Your inventory is full! Sell something first!");
        }
        else {
            ArrayList<String> confirmation = new ArrayList<>();
            confirmation.add("Yes"); confirmation.add("No");
            String choice = ConsoleUtils.printMenuToConsole("Are you sure you would like to buy this item?", confirmation, true);
            switch(Objects.requireNonNull(choice)){
                case "Yes":
                    List<Item> inventory = user.getInventory();
                    inventory.add(j);
                    user.setInventory(inventory);
                    user.setBalance(user.getBalance() - j.getValue());
                    arcade.saveUsersToFile();
                    System.out.println("Purchased!");
                case "No":
                    onEnter(user);
            }
        }
    }

    void sellHandler(User user){
        List<Item> inventory = user.getInventory();
        if (!inventory.isEmpty()) {
            Item j = ConsoleUtils.printMenuToConsole("What would you like to sell?", inventory, true);
            ArrayList<String> confirmation = new ArrayList<>();
            confirmation.add("Yes"); confirmation.add("No");
            String choice = ConsoleUtils.printMenuToConsole("You will receive 50% of the item's value. Are you sure you would like to sell this item?", confirmation, true);
            switch(Objects.requireNonNull(choice)){
                case "Yes":
                    inventory.remove(j);
                    user.setInventory(inventory);
                    assert j != null;
                    user.setBalance(user.getBalance() + 0.5*j.getValue());
                    arcade.saveUsersToFile();
                    System.out.println("Sold!");
                case "No":
                    onEnter(user);
            }
        }
        else {
            System.out.println("You don't have any items to sell!");
            onEnter(user);
        }
    }
}
