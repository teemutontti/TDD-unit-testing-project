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

    // formDate tests
    @Test
    public void testFormDate() {
        Transaction transaction = new Transaction(1, 5, false);
        Assert.assertEquals("2023/10/09", transaction.formDate());
    }

    // Getter tests
    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction(100, 0, false);
        Assert.assertEquals("100.0 €", transaction.getAmount());
    }
}