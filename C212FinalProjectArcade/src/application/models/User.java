package application.models;

import java.util.List;

public class User {

    private String username;
    private double balance;
    private List<Item> inventory;

    public User(String username, double balance, List<Item> inventory){
        this.username = username;
        this.balance = balance;
        this.inventory = inventory;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString(){
        String usrnm = this.username;
        String bal = this.balance + "";
        String inv = "";
        switch(this.inventory.size()){
            case 0: break;
            case 1: inv += this.inventory.get(0); break;
            case 2: inv = inv + this.inventory.get(0) + "," + this.inventory.get(1); break;
            case 3: inv = inv + this.inventory.get(0) + "," + this.inventory.get(1) + "," + this.inventory.get(2); break;
        }
        return usrnm + "|" + bal + "|" + inv;
    }
}
