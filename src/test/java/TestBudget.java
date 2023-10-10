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
        Amount income = new Amount(0, 0);
        Amount expense = new Amount(0, 0);
        Amount balance = new Amount(0, 0);
        Amount goal = new Amount(100, 0);
        ArrayList<Transaction> transactions = new ArrayList<>();

        Budget budget = new Budget(budgetName, month, income, expense, balance, goal, transactions);
        Assert.assertNotNull(budget);
    }
}