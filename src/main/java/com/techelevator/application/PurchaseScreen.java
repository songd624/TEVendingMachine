package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.util.Scanner;

public class PurchaseScreen {
    private Scanner scanner = new Scanner(System.in);
    private Balance balance;
    private Logger logger;
    private FeedMoney option;
    private PurchaseItem purchaseItem;
    private VendingItems vendingItems;

    public PurchaseScreen () {
        this.balance = new Balance();
        this.logger = new Logger();
        this.option = new FeedMoney();
        //this.purchaseItem = new PurchaseItem();  todo:fix this
        this.vendingItems = new VendingItems();
    }

    public void purchaseMenu() {
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
        System.out.println();
        System.out.println("Here are the options: ");
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Option");
        System.out.println("(F) Finish Transaction");
        System.out.println("Please input M/S/F");
        System.out.println("Or else input 'menu' to go back to the main menu");
        System.out.println();
        System.out.println("*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*");
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
            vendingItems.displayVendingItems();
            purchaseItem.purchaseItem(balance.getBalance());
        }



    }

}
