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
        readFile();
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("              Vending Machine Inventory");
        System.out.println("***************************************************");
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
            System.out.printf("\n %-20s %-20s %s %-20d",
                    slotFormatted, itemNameFormatted, itemPriceFormatted, stock);

        }

    }

    public void purchaseItem() {
        displayVendingItems();
        System.out.println();
        System.out.println("Your current balance is: " + balance.getCurrentBalance());
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

        }
    }

}


