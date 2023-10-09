package main.java;
import main.java.Amount;
import main.java.Category;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Transaction {
    private Amount amount;
    private Category category;
    private boolean isIncome;
    private String date;

    // Constructor
    public Transaction(int euros, int cents, boolean isIncome) {
        this.amount = new Amount(euros, cents);
        this.isIncome = isIncome;
        this.date = formDate();
        this.category = null;
    }
    public Transaction(int euros, int cents, boolean isIncome, String category) {
        this.amount = new Amount(euros, cents);
        this.isIncome = isIncome;
        this.date = formDate();
        this.category = null; // TODO: Check if category is created
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