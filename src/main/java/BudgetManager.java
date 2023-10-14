package main.java;

import java.util.*;

public class BudgetManager {
    ArrayList<Budget> budgets;

    // Constructor
    public BudgetManager() {
        this.budgets = new ArrayList<Budget>();
    }

    // Functions
    public void addBudget() {
        Budget budget = new Budget("Test Budget", "Lokakuu", new Amount(10000, false));
        this.budgets.add(budget);
    }

    // Getters
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
}