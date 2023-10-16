package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Budget;
import main.Amount;

@RunWith(JUnit4.class)
public class TestBudget {

    /* --- Constructor tests --- */
    @Test
    public void testConstructorNotNull() {
        String budgetName = "My First Budget";
        String month = "Lokakuu";
        Amount goal = new Amount(10000, false);

        Budget budget = new Budget(budgetName, month, goal);
        assertNotNull(budget);
    }

    /* --- Function tests --- */
    // addTransaction() tests
    @Test
    public void testAddSingleTransaction() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addTransaction("1st transaction", "", 25000, false, "", true);
        assertEquals("250.00", budget.getIncome());
        assertEquals("0.00", budget.getExpense());
        assertEquals("250.00", budget.getBalance());
        assertEquals(1, budget.getTransactions().size());
    }
    @Test
    public void testAddMultipleTransactions() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addTransaction("1st transaction", "", 25000, false, "", true);
        budget.addTransaction("2nd transaction", "", 10000, false, "", false);
        assertEquals("250.00", budget.getIncome());
        assertEquals("100.00", budget.getExpense());
        assertEquals("150.00", budget.getBalance());
        assertEquals(2, budget.getTransactions().size());
    }

    // addIncome() tests
    @Test
    public void testAddIncomePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(1000);
        assertEquals("10.00", budget.getIncome());
    }
    @Test
    public void testAddIncomeNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(-12000);
        assertEquals("120.00", budget.getIncome());
    }

    // addExpense() tests
    @Test
    public void testAddExpensePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(700);
        assertEquals("7.00", budget.getExpense());
    }
    @Test
    public void testAddExpenseNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(-80);
        assertEquals("0.80", budget.getExpense());
    }

    // updateBalance() tests
    @Test
    public void testUpdateBalancePositive() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addIncome(1000);
        budget.updateBalance();
        assertEquals("10.00", budget.getBalance());
    }
    @Test
    public void testUpdateBalanceNegative() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000, false));
        budget.addExpense(1200);
        budget.updateBalance();
        assertEquals("-12.00", budget.getBalance());
    }

    /* --- Getter tests --- */
    @Test
    public void testGetBalance() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("0.00", budget.getBalance());
    }
    @Test
    public void testGetIncome() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("0.00", budget.getIncome());
    }
    @Test
    public void testGetExpense() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("0.00", budget.getExpense());
    }
    @Test
    public void testGetName() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("My Budget", budget.getName());
    }
    @Test
    public void testGetMonth() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("Lokakuu", budget.getMonth());
    }
    @Test
    public void testGetGoal() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        assertEquals("100.00", budget.getGoal());
    }

    /* --- Setter tests --- */
    @Test
    public void testSetName() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        budget.setName("Teemu's Budget");
        assertEquals("Teemu's Budget", budget.getName());
    }
    @Test
    public void testSetMonth() {
        Budget budget = new Budget("My Budget", "Lokakuu", new Amount(10000,false));
        budget.setMonth("Marraskuu");
        assertEquals("Marraskuu", budget.getMonth());
    }
}