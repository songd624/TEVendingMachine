package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class VendingItems {

    private Balance balance = new Balance();
    private Map<String, VendingItem> vendingItemsMap = new HashMap<>();

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_LIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
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
            e.printStackTrace();
        }
    }

    public void displayVendingItems() {

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
        for (String key  : keyList) {
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
        BigDecimal getCurrentBalanceBd = new BigDecimal(Double.toString(currentBalance));
        getCurrentBalanceBd = getCurrentBalanceBd.setScale(2, RoundingMode.HALF_UP);
        System.out.println("Your current balance is: $" + getCurrentBalanceBd);
        System.out.println("Please choose an option to purchase");
        System.out.println("Or input menu to go to the main menu.");
        Scanner vendingOption = new Scanner(System.in);
        String userChoice = vendingOption.nextLine();
        String userChoiceCaps = userChoice.toUpperCase();

        while (!vendingItemsMap.containsKey(userChoiceCaps) && !userChoice.equalsIgnoreCase("menu")) {
            System.out.println("Please make a selection among the available items");
            userChoice = vendingOption.nextLine();
            userChoiceCaps = userChoice.toUpperCase();
        }

        if (userChoice.equalsIgnoreCase("menu")) {
            UserOutput.displayHomeScreen();
        } else {
            VendingItem item = vendingItemsMap.get(userChoiceCaps);
            int currentStock = item.getStock();
            //if item is sold out
            if (currentStock == 0) {
                System.out.println("The item is out of stock. \nPlease choose another item or input menu" +
                        " to go to the main menu.");
                purchaseItem();
            }

            double price = item.getPrice();
            ;
            //if there is not enough money for the item selected
            if (currentBalance - price <= 0) {
                System.out.println("You do not have the necessary funds. \nMake another choice or input menu" +
                        " to go the main menu");
                purchaseItem();
            }

            //Get attributes to print out if purchase
            String name = item.getItemName();
            String itemType = item.getItemType();
            String message = "";
            if (itemType.equalsIgnoreCase("Munchy")) {
                message = "Munchy, Munchy, so Good!";
            } else if (itemType.equalsIgnoreCase("candy")) {
                message = "Sugar, Sugar, so Sweet!";
            } else if (itemType.equalsIgnoreCase("drink")) {
                message = "Drinky, Drinky, Slurp Slurp!";
            } else {
                message = "Chewy, Chewy, Lots O Bubbles!";
            }
            currentStock -= 1;
            item.setStock(currentStock);


            //logger
            String nameFormatted = String.format("%-15s", name);
            String slot = item.getSlot();
            String slotFormatted = String.format("%-5s", slot);
            BigDecimal currentBalanceBd = new BigDecimal(currentBalance);
            currentBalanceBd = currentBalanceBd.setScale(2, RoundingMode.HALF_UP);

            double newBalance = currentBalance - price;
            BigDecimal newBalanceBd = new BigDecimal(Double.toString(newBalance));
            newBalanceBd = newBalanceBd.setScale(2, RoundingMode.HALF_UP);
            String newBalanceStrFormatted = String.format("%8s", newBalanceBd);
            String loggerWrite = nameFormatted + slotFormatted + currentBalanceBd + newBalanceStrFormatted;
            this.logger.write(loggerWrite);

            balance.setCurrentBalance(currentBalance - price);
            //todo: format this:
            System.out.println(name + "  " + "$" + price + "  " + message);
            purchaseItem();
        }
    }

}


