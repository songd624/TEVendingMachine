package com.techelevator.application;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class VendingItemsTest
{

    @Test
    public void readFile()
    {
        Map<String, VendingItem> testMap = new HashMap<>();
        testMap.put("A1", new VendingItem("A1", "U-Chews", 1.65, "Gum"));
        testMap.put("B1", new VendingItem("B1", "Ginger Ayle",1.85,"Drink"));

        VendingItems vendingItems = new VendingItems();

        vendingItems.readFile();
        vendingItems.getVendingItemsMap();

        assertEquals("A1", vendingItems.getVendingItemsMap().get("A1").getSlot());
    }

    @Test
    public void readFile02()
    {
        Map<String, VendingItem> testMap = new HashMap<>();
        testMap.put("A1", new VendingItem("A1", "U-Chews", 1.65, "Gum"));
        testMap.put("B1", new VendingItem("B1", "Ginger Ayle",1.85,"Drink"));

        VendingItems vendingItems = new VendingItems();

        vendingItems.readFile();
        vendingItems.getVendingItemsMap();


        assertEquals(1.65, vendingItems.getVendingItemsMap().get("A1").getPrice(), 0.01);
    }

    @Test
    public void readFile03()
    {
        Map<String, VendingItem> testMap = new HashMap<>();
        testMap.put("A1", new VendingItem("A1", "U-Chews", 1.65, "Gum"));
        testMap.put("B1", new VendingItem("B1", "Ginger Ayle",1.85,"Drink"));

        VendingItems vendingItems = new VendingItems();

        vendingItems.readFile();
        vendingItems.getVendingItemsMap();


        assertEquals("Drink", vendingItems.getVendingItemsMap().get("B1").getItemType(), "Drink");
    }
}
