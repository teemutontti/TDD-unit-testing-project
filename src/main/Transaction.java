package main;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private String name;
    private String notes;
    private int cents;
    private Amount amount;
    private String category;
    private boolean isIncome;
    private String date;

    // Constructor
    public Transaction(String name, String notes, int cents, boolean isNegative, String category, boolean isIncome) {
        if (cents > 0) {
            this.name = name;
            this.notes = notes;
            this.cents = cents;
            this.amount = new Amount(cents, isNegative);
            this.category = category;
            this.isIncome = isIncome;
            this.date = formDate();
        } else {
            throw new IllegalArgumentException("Amount must be over zero!");
        }
    }

    @Override
    public String toString() {
        if (this.isIncome) {
            return this.name + ", +" + this.amount.getAmount() + ", " + this.date;
        } else {
            return this.name + ", -" + this.amount.getAmount() + ", " + this.date;
        }
    }

    // Form current date
    public String formDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    // Getters
    public String getName() {
        return this.name;
    }

    public String getNotes() {
        return this.notes;
    }

    public int getCents() {
        return this.cents;
    }

    public String getAmount() {
        return this.amount.getAmount();
    }

    public String getCategory() {
        return this.category;
    }

    public String getDate() {
        return this.date;
    }

    public boolean getIsIncome() {
        return this.isIncome;
    }
}