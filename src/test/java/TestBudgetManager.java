package test.java;

import java.util.ArrayList;

import org.junit.*;

import main.java.Budget;
import main.java.BudgetManager;

public class TestBudgetManager {

    // Constructor tests
    @Test
    public void testConstructor() {
        BudgetManager budgetManager = new BudgetManager();
        Assert.assertNotNull(budgetManager);
    }

    // getBudgets() tests
    @Test
    public void testGetBudgetsNull() {
        BudgetManager budgetManager = new BudgetManager();
        Assert.assertEquals(0, budgetManager.getBudgets().size());
    }

    // addBudget() tests
    @Test
    public void testAddBudget() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget();
        Assert.assertEquals(1, budgetManager.getBudgets().size());
    }
}