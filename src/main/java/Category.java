package main.java;

import java.util.ArrayList;

public class Category {
    private String name;
    private boolean isNeed;
    private ArrayList<String> transactions;

    private int nameLengthLimit = 20;

    public Category(String name, boolean isNeed) {
        if (name.length() < nameLengthLimit && name.length() > 0) {
            this.name = name;
            this.isNeed = isNeed;
            this.transactions = new ArrayList<String>();
        } else {
            throw new IllegalArgumentException("Category name exceeds it's limitations");
        }
    }

    // Name GETTER
    public String getName() {
        return this.name;
    }
    // IsNeed GETTER
    public boolean getIsNeed() {
        return this.isNeed;
    }
}