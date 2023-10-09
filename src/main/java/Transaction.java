package main.java;
import main.java.Amount;
import main.java.Category;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private String name;
    private String notes;
    private Amount amount;
    private Category category;
    private boolean isIncome;
    private String date;

    // Constructor
    public Transaction(String name, String notes, int euros, int cents, String category, boolean isIncome) {
        this.name = name;
        this.notes = notes;
        this.amount = new Amount(euros, cents);
        this.category = null;  // TODO: Check if category is created
        this.isIncome = isIncome;
        this.date = formDate();
    }

    // Form current date
    public String formDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        return formatter.format(now);
    }

    // Getters
    public String getAmount() {
        return this.amount.getAmount();
    }
    public String getDate() {
        return this.date;
    }
    public boolean getIsIncome() {
        return this.isIncome;
    }
    // TODO: Add getter for category
}