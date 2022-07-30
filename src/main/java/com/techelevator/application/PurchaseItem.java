package com.techelevator.application;

import java.math.BigDecimal;
import java.util.Scanner;

public class PurchaseItem {
   private double balance;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";

    public PurchaseItem(double currentBalance) {
        this.balance = currentBalance;
    }

//    public void purchaseItem(double currentBalance) {
//        if(currentBalance == 0.00)
//        {
//            System.out.println("Your current balance is: " + ANSI_RED + currentBalance + ANSI_RESET);
//        }
//        else
//        {
//            System.out.println("Your current balance is: " + ANSI_GREEN + currentBalance + ANSI_RESET);
//        }
//        System.out.println("Please choose an option to purchase");
//        System.out.println("Or input menu to go to the main menu.");



        Scanner vendingOption = new Scanner(System.in);

    }

