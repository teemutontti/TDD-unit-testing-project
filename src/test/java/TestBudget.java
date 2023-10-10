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
}