package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.BudgetManager;
import main.Amount;

@RunWith(JUnit4.class)
public class TestBudgetManager {

    // Constructor tests
    @Test
    public void testConstructor() {
        BudgetManager budgetManager = new BudgetManager();
        assertNotNull(budgetManager);
    }

    // getBudgets() tests
    @Test
    public void testGetBudgetsNull() {
        BudgetManager budgetManager = new BudgetManager();
        assertEquals(0, budgetManager.getBudgets().size());
    }

    // addBudget() tests
    @Test
    public void testAddBudget() {
        BudgetManager budgetManager = new BudgetManager();
        budgetManager.addBudget("My Budget", "lokakuu", new Amount(10000, false));
        assertEquals(1, budgetManager.getBudgets().size());
    }
}