package main.java;

import java.util.*;
import main.java.Amount;
import main.java.Transaction;

public class Budget {

    // Variables
    String name;
    String month;
    Amount incomeAmount;
    Amount expenseAmount;
    Amount balanceAmount;
    Amount goalAmount;
    ArrayList<Transaction> transactions;

    // Constructor
    public Budget(String name, String month, Amount income, Amount expense, Amount balance, Amount goal, ArrayList<Transaction> transactions) {
        this.name = name;
        this.month = month;
        this.incomeAmount = income;
        this.expenseAmount = expense;
        this.balanceAmount = balance;
        this.goalAmount = goal;
        this.transactions = transactions;
    }
}