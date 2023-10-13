package test.java;

import org.junit.*;

import main.java.Transaction;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class TestTransaction {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    private String currentDate = formatter.format(now);

    // Constructor
    @Test
    public void testConstructor() {
        Transaction transaction = new Transaction("Tikkari K-market", "", 105, false, "", false);
        Assert.assertNotNull(transaction);
    }

    //toString tests
    @Test
    public void testToString() {
        Transaction transaction = new Transaction("Tikkari", "", 105, false, "", false);
        Assert.assertEquals("Tikkari 1.05 € 2023/10/14", transaction.toString());
    }

    // formDate tests
    @Test
    public void testFormDate() {
        Transaction transaction = new Transaction("Tikkari S-market", "", 150, false, "", false);
        Assert.assertEquals(currentDate, transaction.formDate());
    }

    // Getter tests
    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction("Näyttö", "", 10000, false, "", false);
        Assert.assertEquals("100.00 €", transaction.getAmount());
        Assert.assertNotEquals("100.0 €", transaction.getAmount());
    }
    @Test
    public void testGetDate() {
        Transaction transaction = new Transaction("Patukka", "", 1, false, "", true);
        Assert.assertEquals(currentDate, transaction.getDate());
    }
    @Test
    public void testGetIsIncome() {
        Transaction transaction = new Transaction("Prosessori Power", "", 500, false, "", false);
        Assert.assertEquals(false, transaction.getIsIncome());
        Assert.assertNotEquals(true, transaction.getIsIncome());
    }
}