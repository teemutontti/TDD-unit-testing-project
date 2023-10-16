package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Transaction;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

@RunWith(JUnit4.class)
public class TestTransaction {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    LocalDateTime now = LocalDateTime.now();
    private String currentDate = formatter.format(now);

    // Constructor
    @Test
    public void testConstructor() {
        Transaction transaction = new Transaction("Tikkari K-market", "", 105, false, "", false);
        assertNotNull(transaction);
    }

    //toString tests
    @Test
    public void testToString() {
        Transaction transaction = new Transaction("Tikkari", "", 105, false, "", false);
        assertEquals("Tikkari, -1.05, "+currentDate, transaction.toString());
    }

    // formDate tests
    @Test
    public void testFormDate() {
        Transaction transaction = new Transaction("Tikkari S-market", "", 150, false, "", false);
        assertEquals(currentDate, transaction.formDate());
    }

    // Getter tests
    @Test
    public void testGetAmount() {
        Transaction transaction = new Transaction("Näyttö", "", 10000, false, "", false);
        assertEquals("100.00", transaction.getAmount());
        assertNotEquals("100.0", transaction.getAmount());
    }
    @Test
    public void testGetDate() {
        Transaction transaction = new Transaction("Patukka", "", 1, false, "", true);
        assertEquals(currentDate, transaction.getDate());
    }
    @Test
    public void testGetIsIncome() {
        Transaction transaction = new Transaction("Prosessori Power", "", 500, false, "", false);
        assertEquals(false, transaction.getIsIncome());
        assertNotEquals(true, transaction.getIsIncome());
    }
}