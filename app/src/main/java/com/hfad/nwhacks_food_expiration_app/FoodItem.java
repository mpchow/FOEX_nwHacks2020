package com.hfad.nwhacks_food_expiration_app;

import java.io.Serializable;
import java.util.*;

public class FoodItem {

    private String itemType;
    private int timeUntilExpire;


    public FoodItem(String ForegroundC, String BackGroundC, List<String> dominantC, List<String> itemsInPicture, Set<String> validItems) {
        this.itemType = assignItem(itemsInPicture, validItems);
        this.timeUntilExpire = expiryDate(ForegroundC, BackGroundC, dominantC, itemType);

    }

    private String assignItem(List<String> itemsInPicture, Set<String> validItems) {
        for (String s : itemsInPicture) {
            if (validItems.contains(s)) {
                return s;
            }
        }
        return "notValid";
    }

    private int expiryDate (String ForegroundC, String BackGroundC, List<String> dominantC, String itemType) {
        int expiryTime = 0;
        if(itemType.equals("banana")) {
            // Check if banana is green
            if (ForegroundC.equals("Green") || (dominantC.contains("Green") && !dominantC.contains("Yellow")) ) {
                expiryTime = 7;
            }
            // check if banana is yellow and green
            else if (dominantC.contains("Yellow") && dominantC.contains("Green")) {
                expiryTime = 5;
            }
            // check if banana is all yellow
            else if (ForegroundC.equals("Yellow") || (dominantC.contains("Yellow") && !dominantC.contains("Green"))) {
                if (!BackGroundC.equals("Brown") && !dominantC.contains("Brown")) {
                    expiryTime = 4;
                }
            }
            // check if contains brown
            else if (ForegroundC.equals("Yellow") && !BackGroundC.equals("Brown") && (dominantC.contains("Brown") || dominantC.contains("Grey"))) {
                expiryTime = 2;
            }
        }
        else if (itemType.equals("apple")) {
            expiryTime = 14;
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