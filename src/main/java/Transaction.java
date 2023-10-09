package main.java;

import main.java.Amount;
import main.java.Category;

public class Transaction {
    private Amount amount;
    private Category category;
    private boolean isIncome;
    private String date;

    // Constructor
    public Transaction(int euros, int cents, boolean isIncome) {
        this.amount = new Amount(euros, cents);
        this.category = null;
    }
    public Transaction(int euros, int cents, boolean isIncome, String category) {
        this.amount = new Amount(euros, cents);
        this.category = null; // TODO: Check if category is created
    }
}