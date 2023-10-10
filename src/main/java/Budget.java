package main.java;

import java.util.*;
import main.java.Amount;
import main.java.Transaction;

public class Budget {
    String name;
    String month;
    Amount goalAmount;

    Amount incomeAmount = new Amount(0, 0);
    Amount expenseAmount = new Amount(0, 0);
    Amount balanceAmount = new Amount(0, 0);
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // Constructor
    public Budget(String name, String month, Amount goal) {
        this.name = name;
        this.month = month;
        this.goalAmount = goal;
    }
}