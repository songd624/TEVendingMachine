package com.techelevator.application;

import java.math.BigDecimal;

public class VendingItem {
    private String slot;
    private String itemName;
    private BigDecimal price;
    private String itemType;
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public VendingItem(String slot, String itemName, BigDecimal price, String itemType) {
        this.slot = slot;
        this.itemName = itemName;
        this.price = price;
        this.itemType = itemType;
        this.stock = 6;

    }

    public void updateQuantity()
    {
        this.stock -= 1;
    }

    public String purchaseMessage()
    {
        switch(this.itemType)
        {
            case "munchy":
                return "Munchy, Munchy, so Good!";
            case "candy":
                return "Sugar, Sugar, so Sweet!";
            case "drink":
                return "Drinky, Drinky, Slurp Slurp!";
            case "gum":
                return "Chewy, Chewy, Lots O Bubbles!";
            default:
                return null;
        }
    }

}
