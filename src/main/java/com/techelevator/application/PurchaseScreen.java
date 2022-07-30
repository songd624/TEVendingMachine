package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class PurchaseScreen {
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;
    private FeedMoney option;
    private VendingItems vendingItems;

    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public PurchaseScreen (VendingItems input) {
        this.balance = new Balance();
        this.logger = new Logger();
        this.option = new FeedMoney();
        this.vendingItems = input;

    }



    public void purchaseMenu() {
        System.out.println(ANSI_GREEN + "*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~"+ ANSI_RESET);
        System.out.println(ANSI_CYAN + "                       Purchase Menu" + ANSI_RESET);
        System.out.println(ANSI_GREEN +"*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~" + ANSI_RESET);
        System.out.println();
        System.out.println("                  Here are your options: ");
        System.out.println("                     (" + ANSI_GREEN + "M" + ANSI_RESET + ") Feed Money");
        System.out.println("                    (" + ANSI_GREEN + "S" + ANSI_RESET + ") Select Option");
        System.out.println("                  (" + ANSI_GREEN + "F" + ANSI_RESET + ") Finish Transaction");
        System.out.println("                Please input '" + ANSI_GREEN + "M" + ANSI_RESET + "','" + ANSI_GREEN + "S" + ANSI_RESET + "', or '" + ANSI_GREEN + "F" + ANSI_RESET + "'");
        System.out.println("            Enter " + "'" + ANSI_GREEN + "menu" + ANSI_RESET + "' to return to the " + ANSI_CYAN + "Main Menu" + ANSI_RESET);
        System.out.println();
        System.out.println(ANSI_GREEN + "*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~" + ANSI_RESET);
        String choice = scanner.nextLine();
        while (!choice.equalsIgnoreCase("M") && !choice.equalsIgnoreCase("S")
                && !choice.equalsIgnoreCase("F") &&
                !choice.equalsIgnoreCase("menu")) {
            System.out.println("Please input M/S/F or menu");
            choice = scanner.nextLine();
        }
        if (choice.equalsIgnoreCase("menu")) {
            UserOutput.displayHomeScreen();
        }
        if (choice.equalsIgnoreCase("m")) {
            option.feedMoney();
        }
        if (choice.equalsIgnoreCase("s")) {
            vendingItems.purchaseItem();
        }



    }

}
