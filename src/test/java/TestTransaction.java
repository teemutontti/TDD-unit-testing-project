package test.java;

import org.junit.*;

import main.java.Category;
import main.java.Transaction;

public class TestTransaction {

    // Constructor
    @Test
    public void testConstructor() {
        Transaction transaction = new Transaction();
        Assert.assertNotNull(transaction);
    }
}