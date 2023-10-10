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

    // Getters
    public String getBalance() {
        return this.balanceAmount.getAmount();
    }
    public String getIncome() {
        return this.incomeAmount.getAmount();
    }
    public String getExpense() {
        return this.expenseAmount.getAmount();
    }
    public String getName() {
        return this.name;
    }
    public String getMonth() {
        return this.month;
    }
    public String getGoal() {
        return this.goalAmount.getAmount();
    }
    public String getTransactions() {
        if (this.transactions.size() > 0) {
            String str = "";
            for (int i=0; i<this.transactions.size(); i++) {
                str = str + this.transactions.get(i).getDate();
            }
            return str;
        } else {
            return "No transactions found!";
        }
    }
}