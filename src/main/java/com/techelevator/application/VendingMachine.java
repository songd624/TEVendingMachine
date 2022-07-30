package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine {
    UserInput userInput = new UserInput();
    UserOutput userOutput = new UserOutput();
    VendingItems vendingItems;
    PurchaseScreen purchaseScreen;
    Logger logger;



    public VendingMachine() {
        this.vendingItems = new VendingItems();
        this.logger = new Logger();
        this.purchaseScreen = new PurchaseScreen(vendingItems);
    }

    public void run() {
        vendingItems.readFile();
        this.logger.write("========START LOG=======");
        while(true) {
            UserOutput.displayHomeScreen();
            String choice = userInput.getHomeScreenOption();

            System.out.println(choice);
            if(choice.equals("display")) {
                vendingItems.displayVendingItems();
                // display the items
            }
            else if(choice.equals("purchase")) {
                purchaseScreen.purchaseMenu();
                // make a purchase
            }
            else if(choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

}
