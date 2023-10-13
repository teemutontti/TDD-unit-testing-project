package test.java;

import org.junit.*;
import main.java.Budget;
import main.java.Amount;

public class TestBudget {

    // Constructor tests
    @Test
    public void testConstructorNotNull() {
        String budgetName = "My First Budget";
        String month = "Lokakuu";
        Amount goal = new Amount(10000, false);

        Budget budget = new Budget(budgetName, month, goal);
        Assert.assertNotNull(budget);
    }

    // Getter tests
    @Test
    public void testGetBalance() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("0.00 €", budget.getBalance());
    }
    @Test
    public void testGetIncome() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("0.00 €", budget.getIncome());
    }
    @Test
    public void testGetExpense() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("0.00 €", budget.getExpense());
    }
    @Test
    public void testGetName() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("My Budget", budget.getName());
    }
    @Test
    public void testGetMonth() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("Lokakuu", budget.getMonth());
    }
    @Test
    public void testGetGoal() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        Assert.assertEquals("100.00 €", budget.getGoal());
    }
    @Test
    public void testGetTransactions() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        Assert.assertEquals("No transactions found!", budget.getTransactions());
    }

    // Setter tests
    @Test
    public void testSetName() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        budget.setName("Teemu's Budget");
        Assert.assertEquals("Teemu's Budget", budget.getName());
    }
    @Test
    public void testSetMonth() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        budget.setMonth("Marraskuu");
        Assert.assertEquals("Marraskuu", budget.getMonth());
    }
}