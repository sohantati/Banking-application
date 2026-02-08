package com.sohantati.bank.model;

public class Account {

    private Long userID;
    private double balance;

    public Account() {}

    public Account(Long userID, double balance){
        this.userID = userID;
        this.balance = balance;
    }

    public Long getUserId() { return userID; }

    public void setUserId(Long userId) { this.userID = userId; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) { this.balance = balance; }
}
