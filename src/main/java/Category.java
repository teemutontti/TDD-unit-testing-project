package main.java;

import java.util.ArrayList;

public class Category {
    private String name;
    private boolean isNeed;
    private ArrayList<String> transactions;

    private int nameLengthLimit = 20;

    public Category(String name, boolean isNeed) {
        if (name.length() < nameLengthLimit && name.length() > 0) {
            this.name = format(name);
            this.isNeed = isNeed;
            this.transactions = new ArrayList<String>();
        } else {
            throw new IllegalArgumentException("Category name exceeds it's limitations");
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public boolean getIsNeed() {
        return this.isNeed;
    }

    // Setters
    public void setName(String name) {
        this.name = format(name);
    }
    public void setIsNeed(boolean isNeed) {
        this.isNeed = isNeed;
    }

    // Format string, first letter to uppercase
    public String format(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}