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
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public void readFile() {
        File cateringFile = new File("catering1.csv");

        try {
            Scanner items = new Scanner(cateringFile);
            while (items.hasNextLine()) {
                String itemsStr = items.nextLine();
                String[] itemsArr = itemsStr.split(",");

                String slot = itemsArr[0];
                String itemName = itemsArr[1];
                BigDecimal itemPrice = new BigDecimal(itemsArr[2]);
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
            BigDecimal itemPrice = item.getPrice();
            String itemPriceFormatted = String.format("%-5s", itemPrice);
            int stock = item.getStock();

            System.out.printf("\n %-22s %-25s %-19s %-20d",
                    ANSI_LIGHT_YELLOW + " " + slotFormatted + ANSI_RESET,
                    itemNameFormatted,
                    ANSI_GREEN + itemPriceFormatted + ANSI_RESET,
                    stock);
        }
        System.out.println(" ");
    }

    public void purchaseItem() {
        displayVendingItems();
        System.out.println();
        if(balance.getCurrentBalance()== 0.00)
        {
            System.out.println("Your current balance is: " + ANSI_RED + balance.getCurrentBalance() + ANSI_RESET);
        }
        else
        {
            System.out.println("Your current balance is: " + ANSI_GREEN + balance.getCurrentBalance() + ANSI_RESET);
        }
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
            String name = item.getItemName();
            BigDecimal price = item.getPrice();
            price = price.setScale(2, RoundingMode.HALF_UP);
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
            int currentStock = item.getStock() - 1;
            item.setStock(currentStock);




            //todo: format this:
            System.out.println(name + "  " + price + "  " + message);
            purchaseItem();
        }
    }

}


