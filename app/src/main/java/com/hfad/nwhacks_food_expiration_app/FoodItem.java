package com.hfad.nwhacks_food_expiration_app;

import java.util.*;

public class FoodItem {

    private String itemType;
    private int timeUntilExpire;


    public FoodItem(String ForegroundC, String BackGroundC, List<String> itemsInPicture, Set<String> validItems) {
        this.itemType = assignItem(itemsInPicture, validItems);
        this.timeUntilExpire = expiryDate(ForegroundC, BackGroundC, itemType);

    }

    private String assignItem(List<String> itemsInPicture, Set<String> validItems) {
        for (String s : itemsInPicture) {
            if (validItems.contains(s)) {
                return s;
            }
        }
        return "notValid";
    }

    private int expiryDate (String ForegroundC, String BackGroundC, String itemType) {
        int expiryTime = 0;
        if(itemType.equals("banana")) {
            if (ForegroundC.equals("green")) {
                expiryTime = 5;
            }
        }

        return expiryTime;
    }

    public void decrementExpiryTime() {
        timeUntilExpire--;
    }

    public boolean isExpired() { return timeUntilExpire <= 0;}

    public String getItemType() { return itemType; }

    public int getExpiryTime() { return timeUntilExpire; }
}