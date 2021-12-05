package edu.iu.c212.models;

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
}
