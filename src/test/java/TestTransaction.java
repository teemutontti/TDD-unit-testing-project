package test.java;

import org.junit.*;

import main.java.Category;
import main.java.Transaction;

public class TestTransaction {

    // Constructor
    @Test
    public void testConstructor() {
        Transaction transaction = new Transaction(1, 5, false);
        Assert.assertNotNull(transaction);
    }
}