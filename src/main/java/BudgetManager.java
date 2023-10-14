package main.java;

import java.util.*;

public class BudgetManager {
    ArrayList<Budget> budgets;

    // Constructor
    public BudgetManager() {
        this.budgets = new ArrayList<Budget>();
    }

    public ArrayList<Budget> getBudgets() {
        return this.budgets;
    }
}