package com.techelevator.application;

public class Balance {
    private double balance;

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double value) {
        this.balance = value;
    }

    public double currentBalance() {
        return getBalance();
    }

}
