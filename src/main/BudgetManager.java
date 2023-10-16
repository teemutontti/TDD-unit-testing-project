package main;

import java.util.*;

public class BudgetManager {
    ArrayList<Budget> budgets;

    // Constructor
    public BudgetManager() {
        this.budgets = new ArrayList<Budget>();
    }

    // Functions
    public void addBudget(String name, String month, Amount goal) {
        Budget budget = new Budget(name, month, goal);
        this.budgets.add(budget);
    }

    // Getters
    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
}