package main.java;

import java.util.*;
import main.java.Amount;
import main.java.Transaction;

public class Budget {
    private String name;
    private String month;
    private Amount goalAmount;

    private Amount incomeAmount = new Amount(0, 0);
    private Amount expenseAmount = new Amount(0, 0);
    private Amount balanceAmount = new Amount(0, 0);
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // Constructor
    public Budget(String name, String month, Amount goal) {
        this.name = name;
        this.month = month;
        this.goalAmount = goal;
    }
}