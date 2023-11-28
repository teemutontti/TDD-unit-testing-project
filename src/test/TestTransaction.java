package test;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Amount;
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

    // toString tests
    @Test
    public void testToString() {
        Transaction transaction = new Transaction("Tikkari", "", 105, false, "", false);
        assertEquals("Tikkari, -1.05, " + currentDate, transaction.toString());
    }

    // formDate tests
    @Test
    public void testFormDate() {
        Transaction transaction = new Transaction("Tikkari S-market", "", 150, false, "", false);
        assertEquals(currentDate, transaction.formDate());
    }

    // Getter tests
    Transaction getterTestTransaction = new Transaction("Näyttö", "jotain", 10000, false, "elektroniikka", false);

    @Test
    public void testGetName() {
        assertEquals("Näyttö", getterTestTransaction.getName());
    }

    @Test
    public void testGetNotes() {
        assertEquals("jotain", getterTestTransaction.getNotes());
    }

    @Test
    public void testGetCents() {
        assertEquals(10000, getterTestTransaction.getCents());
    }

    @Test
    public void testGetAmount() {
        assertEquals("100.00", getterTestTransaction.getAmount());
    }

    @Test
    public void testGetCategory() {
        assertEquals("elektroniikka", getterTestTransaction.getCategory());
    }

    @Test
    public void testGetDate() {
        assertEquals(currentDate, getterTestTransaction.getDate());
    }

    @Test
    public void testGetIsIncome() {
        assertEquals(false, getterTestTransaction.getIsIncome());
    }
}