package com.techelevator.application;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseItem {
   private double balance;

    public PurchaseItem(double currentBalance) {
        this.balance = currentBalance;
    }

    public void purchaseItem(double currentBalance) {
        System.out.println("Your current balance is: " + currentBalance);
        System.out.println("Please choose an option to purchase");
        System.out.println("Or input menu to go to the main menu.");
        Scanner vendingOption = new Scanner(System.in);

    }
}
