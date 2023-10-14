package test.java;

import org.junit.*;
import main.java.Budget;
import main.java.Transaction;
import main.java.Amount;

public class TestBudget {

    /* --- Constructor tests --- */
    @Test
    public void testConstructorNotNull() {
        String budgetName = "My First Budget";
        String month = "Lokakuu";
        Amount goal = new Amount(10000, false);

        Budget budget = new Budget(budgetName, month, goal);
        Assert.assertNotNull(budget);
    }

    /* --- Function tests --- */
    // addTransaction() tests
    @Test
    public void testAddSingleTransaction() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        Transaction transaction = new Transaction("1st transaction", "", 10000, false, null, true);
        budget.addTransaction(transaction);
        Assert.assertEquals(1, budget.getTransactions().size());
    }
    @Test
    public void testAddMultipleTransactions() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        Transaction transaction = new Transaction("1st transaction", "", 10000, false, null, true);
        for (int i=0; i<10; i++) {
            budget.addTransaction(transaction);
        }
        Assert.assertEquals(10, budget.getTransactions().size());
    }

    // addIncome() tests
    @Test
    public void testAddIncomePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(1000);
        Assert.assertEquals("10.00 €", budget.getIncome());
    }
    @Test
    public void testAddIncomeNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(-12000);
        Assert.assertEquals("120.00 €", budget.getIncome());
    }

    // addExpense() tests
    @Test
    public void testAddExpensePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(700);
        Assert.assertEquals("7.00 €", budget.getExpense());
    }
    @Test
    public void testAddExpenseNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(-80);
        Assert.assertEquals("0.80 €", budget.getExpense());
    }

    // updateBalance() tests
    @Test
    public void testUpdateBalancePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(1000);
        budget.updateBalance();
        Assert.assertEquals("10.00 €", budget.getBalance());
    }
    @Test
    public void testUpdateBalanceNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(1200);
        budget.updateBalance();
        Assert.assertEquals("-12.00 €", budget.getBalance());
    }

    /* --- Getter tests --- */
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

    /* --- Setter tests --- */
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