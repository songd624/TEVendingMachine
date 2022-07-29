package com.techelevator.application;

public class Balance {
    //private double balance;
    private static double currentBalance;

    //public double getBalance() {
    //    return this.balance;
    // }

    //public void setBalance(double value) {
    //    this.balance = balance;
    //}

    public double getCurrentBalance() {
        return currentBalance;
    }

    // public double currentBalance() {
    //    double currentBalance = getBalance();
    //    return currentBalance;
    // }

    public void setCurrentBalance(double inputMoney) {
        currentBalance = inputMoney;
    }

}
