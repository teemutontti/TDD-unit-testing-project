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
        Assert.assertEquals(new ArrayList<Budget>(), budgetManager.getBudgets());
    }
}