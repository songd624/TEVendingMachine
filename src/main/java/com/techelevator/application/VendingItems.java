package com.techelevator.application;

import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingItems {


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
            System.out.println("ERROR: File NOT Found...");;
        }
    }

    public void displayVendingItems() {

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
            System.out.printf("\n %-20s %-20s %-5s | %d",
                    slotFormatted, itemNameFormatted,  itemPriceFormatted, stock);

        }

    }
}
