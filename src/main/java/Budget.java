package main.java;

import java.util.*;

public class Budget {
    private String name;
    private String month;
    private Amount goalAmount;

    private Amount incomeAmount = new Amount(0, false);
    private Amount expenseAmount = new Amount(0, false);
    private Amount balanceAmount = new Amount(0, false);
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    // Constructor
    public Budget(String name, String month, Amount goal) {
        this.name = name;
        this.month = month;
        this.goalAmount = goal;
    }

    //
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void updateBalance() {
        int balanceUpdatedEuros = this.incomeAmount.getEuros() - this.expenseAmount.getEuros();
        int balanceUpdatedCents = this.incomeAmount.getCents() - this.expenseAmount.getCents();
        this.balanceAmount = new Amount(balanceUpdatedEuros, balanceUpdatedCents);
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
    public ArrayList<Transaction> getTransactions() {
        return this.transactions;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMonth(String month) {
        this.month = month;
    }
}