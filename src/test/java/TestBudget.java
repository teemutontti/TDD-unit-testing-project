package test.java;

import org.junit.*;
import main.java.Budget;

public class TestBudget {

    // Constructor tests
    @Test
    public void testConstructor() {
        Budget budget = new Budget();
        Assert.assertNotNull(budget);
    }
}