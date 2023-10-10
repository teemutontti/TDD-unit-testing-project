package test.java;

import org.junit.*;
import java.util.*;
import main.java.Budget;
import main.java.Amount;
import main.java.Transaction;

public class TestBudget {

    // Constructor tests
    @Test
    public void testConstructorNotNull() {
        String budgetName = "My First Budget";
        String month = "Lokakuu";
        Amount goal = new Amount(100, 0);

        Budget budget = new Budget(budgetName, month, goal);
        Assert.assertNotNull(budget);
    }

    // getBalance() tests
    @Test
    public void testGetBalance() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("0.00 €", budget.getBalance());
    }
    @Test
    public void testGetIncome() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("0.00 €", budget.getIncome());
    }
    @Test
    public void testGetExpense() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("0.00 €", budget.getExpense());
    }
    @Test
    public void testGetName() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("My Budget", budget.getName());
    }
    @Test
    public void testGetMonth() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("Lokakuu", budget.getMonth());
    }
    @Test
    public void testGetGoal() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100,0));
        Assert.assertEquals("100.00 €", budget.getGoal());
    }
    @Test
    public void testGetTransactions() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(100, 0));
        Assert.assertEquals("No transactions found!", budget.getTransactions());
    }
}