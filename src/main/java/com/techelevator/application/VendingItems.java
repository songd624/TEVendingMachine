package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingItems {

    private Balance balance = new Balance();
    private static Map<String, VendingItem> vendingItemsMap = new HashMap<>();
    private FinishTransaction finishTransaction = new FinishTransaction();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001b[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private Logger logger = new Logger();


    public void readFile() {
        File cateringFile = new File("catering1.csv");

        try {
            Scanner items = new Scanner(cateringFile);
            while (items.hasNextLine()) {
                String itemsStr = items.nextLine();
                String[] itemsArr = itemsStr.split(",");

                String slot = itemsArr[0];
                String itemName = itemsArr[1];
                double itemPrice = Double.parseDouble(itemsArr[2]);
                String itemType = itemsArr[3];
                vendingItemsMap.put(slot, new VendingItem(slot, itemName, itemPrice, itemType));

            }
        } catch (FileNotFoundException e) {
            System.out.println(ANSI_RED + "Error: File NOT Found Exception" + ANSI_RESET);
        }
    }

    public static void displayVendingItems() {

        System.out.println();
        System.out.println("**********************************************************");
        System.out.println(ANSI_CYAN + "               Vending Machine Inventory" + ANSI_RESET);
        System.out.println("**********************************************************");

        System.out.println(ANSI_LIGHT_YELLOW + "----------------------------------------------------------");
        System.out.println("|" + ANSI_RESET + " ID " + ANSI_LIGHT_YELLOW + "|            |"
                + ANSI_RESET + " ITEM " + ANSI_LIGHT_YELLOW + "|               |"
                + ANSI_RESET + " PRICE " + ANSI_LIGHT_YELLOW + "| |"
                + ANSI_RESET + " Qty " + ANSI_LIGHT_YELLOW + "|");
        System.out.println("----------------------------------------------------------" + ANSI_RESET);


        Set<String> keys = vendingItemsMap.keySet();
        List<String> keyList = new ArrayList<>(keys);
        Collections.sort(keyList);
        for (String key : keyList) {
            VendingItem item = vendingItemsMap.get(key);

            String slot = item.getSlot();
            String slotFormatted = String.format("%-15s", slot);
            String itemName = item.getItemName();
            String itemNameFormatted = String.format("%5s", itemName);
            double itemPrice = item.getPrice();
            String itemPriceFormatted = String.format("%-5s", itemPrice);
            int stock = item.getStock();

            System.out.printf("\n %-22s %-25s %-19s %-20d",
                    ANSI_LIGHT_YELLOW + " " + slotFormatted + ANSI_RESET,
                    itemNameFormatted,
                    ANSI_GREEN + "$" + itemPriceFormatted + ANSI_RESET,
                    stock);
        }
        System.out.println(" ");
    }

    public void purchaseItem() {
        displayVendingItems();

        double currentBalance = balance.getCurrentBalance();
        System.out.println();

        //Check funds
        checkFunds(currentBalance);

        Scanner vendingOption = new Scanner(System.in);
        String userChoice = vendingOption.nextLine();
        String userChoiceCaps = userChoice.toUpperCase();

        while (!vendingItemsMap.containsKey(userChoiceCaps) && !userChoice.equalsIgnoreCase("menu")
                &&!userChoice.equalsIgnoreCase("f")) {
            System.out.println("  Please make a selection among the available items...");
            userChoice = vendingOption.nextLine();
            userChoiceCaps = userChoice.toUpperCase();
        }


        //check if user input is menu
        if (userChoiceCaps.equalsIgnoreCase("menu")) {
            UserOutput.displayHomeScreen();
        }


        else if(userChoiceCaps.equalsIgnoreCase("F")) {     //TODO loading main menu
            finishTransaction.completeTransaction();
        }
        else {          //TODO menu list NOT called when SELECT ITEM menu called from FEED MONEY menu

            //if valid input get all info needed
            VendingItem item = vendingItemsMap.get(userChoiceCaps);
            int currentStock = item.getStock();
            double price = item.getPrice();
            String name = item.getItemName();
            String itemType = item.getItemType();
            String slot = item.getSlot();

            //check stock
            if (currentStock == 0) {
                checkNoStock();
            }
            //check if there's enough money to buy
            else if (currentBalance - price < 0) {
                notEnoughFunds();
            }
            //passed all checks, buy the item and log it!
            else {
                currentStock -= 1;
                item.setStock(currentStock);

                balance.setCurrentBalance(currentBalance - price);
                //logger
                purchaseLogger(slot, name, price, itemType, currentBalance);
            }
        }
    }


    public void checkFunds(double currentBalance) {
        BigDecimal getCurrentBalanceBd = new BigDecimal(Double.toString(currentBalance));
        getCurrentBalanceBd = getCurrentBalanceBd.setScale(2, RoundingMode.HALF_UP);
        if (!getCurrentBalanceBd.equals(new BigDecimal("0.00"))) {
            System.out.println("            Current Money Provided: " + "$" +
                    ANSI_GREEN + getCurrentBalanceBd + ANSI_RESET);


            System.out.println("     Please input the items' " + ANSI_LIGHT_YELLOW + "ID" + ANSI_RESET + " code to purchase...");
            System.out.println("       Input '" + ANSI_BLUE + "F" + ANSI_RESET +
                    "' to finish your transaction." + ANSI_RESET);
            System.out.println("       Input '" + ANSI_CYAN + "menu" + ANSI_RESET +
                    "' to return to the " + ANSI_CYAN + "Main Menu" + ANSI_RESET);

        } else {
            System.out.println("           Your current balance is: $" +
                    ANSI_RED + getCurrentBalanceBd + ANSI_RESET);

            //TODO link to feedMoney, delete subsequent SysOut below once linked
//            System.out.println("        Enter '" + ANSI_GREEN + "M" + ANSI_RESET +
//                    "' to go to the " + ANSI_GREEN + "Feed Money " + ANSI_RESET + "menu...");
//            System.out.println("Please input '" + ANSI_CYAN  + "menu" + ANSI_RESET + "' to return to the Main Menu...");


            System.out.println("Please input '" + ANSI_CYAN  + "menu" + ANSI_RESET + "' and add money to your balance before purchasing...");
        }
    }

    public void checkNoStock() {
            System.out.println(ANSI_RED + "        Sorry, this item is out of stock... " + ANSI_RESET);
            System.out.println("            Please choose another item...");
            System.out.println("        Enter '" + ANSI_CYAN + "menu" + ANSI_RESET +
                    "' to return to the " + ANSI_CYAN + "Main Menu" + ANSI_RESET);

            purchaseItem();
    }

    public void notEnoughFunds() {
            System.out.println(ANSI_RED + "       Sorry, you do not have the necessary funds... " + ANSI_RESET);

            //TODO
           //     System.out.println("       If you would like add money enter '" + ANSI_GREEN + "feed" + ANSI_RESET + "'...");

            System.out.println("        Enter '" + ANSI_CYAN + "menu" + ANSI_RESET +
                    "' to return to the " + ANSI_CYAN + "Main Menu" + ANSI_RESET);
            purchaseItem();
    }


    public void purchaseLogger(String slotNumber, String itemName, double price, String type, double currentBalance) {
        String message = "";
        if (type.equalsIgnoreCase("Munchy")) {
            message = ANSI_BLUE + "Munchy, Munchy, so Good!" + ANSI_RESET;
        } else if (type.equalsIgnoreCase("candy")) {
            message = ANSI_LIGHT_YELLOW + "Sugar, Sugar, so Sweet!" + ANSI_RESET;
        } else if (type.equalsIgnoreCase("drink")) {
            message = ANSI_RED + "Drinky, Drinky, Slurp Slurp!" + ANSI_RESET;
        } else {
            message = ANSI_PURPLE + "Chewy, Chewy, Lots O Bubbles!" + ANSI_RESET;
        }

        String nameFormatted = String.format("%-15s", itemName);

        String slotFormatted = String.format("%-5s", slotNumber);
        BigDecimal currentBalanceBd = new BigDecimal(currentBalance);
        currentBalanceBd = currentBalanceBd.setScale(2, RoundingMode.HALF_UP);

        double newBalance = currentBalance - price;
        BigDecimal newBalanceBd = new BigDecimal(Double.toString(newBalance));
        newBalanceBd = newBalanceBd.setScale(2, RoundingMode.HALF_UP);
        String newBalanceStrFormatted = String.format("%8s", newBalanceBd);
        String loggerWrite = nameFormatted + slotFormatted + currentBalanceBd + newBalanceStrFormatted;
        Logger.write(loggerWrite);


        //todo: format this:
        System.out.println(itemName + "  " + "$" + price + "  " + message);

        //once sale is complete, go back to purchase item screen
        purchaseItem();
    }
}





