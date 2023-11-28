package test;

import static org.junit.Assert.*;
import org.junit.Test;
//import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import main.Amount;

@RunWith(JUnit4.class)
public class TestAmount {

    // Constructor tests
    @Test(expected = IllegalArgumentException.class)
    public void testTenThousand() {
        new Amount(1000000, false);
    }

    @Test
    public void testUnderThousand() {
        Amount amount = new Amount(999999, false);
        assertNotNull(amount);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUnderZero() {
        new Amount(-100, true);
    }

    @Test
    public void testZeroPositive() {
        Amount amount = new Amount(0, false);
        assertEquals("0.00", amount.getAmount());
    }

    @Test
    public void testZeroNegative() {
        Amount amount = new Amount(0, true);
        assertEquals("0.00", amount.getAmount());
    }

    @Test
    public void testSingleCentsPositive() {
        Amount amount = new Amount(1, false);
        assertEquals("0.01", amount.getAmount());
    }

    @Test
    public void testSingleCentsNegative() {
        Amount amount = new Amount(9, true);
        assertEquals("-0.09", amount.getAmount());
    }

    @Test
    public void testTenCentsPositive() {
        Amount amount = new Amount(10, false);
        assertEquals("0.10", amount.getAmount());
    }

    @Test
    public void testTenCentsNegative() {
        Amount amount = new Amount(99, true);
        assertEquals("-0.99", amount.getAmount());
    }

    @Test
    public void testSingleEurosPositive() {
        Amount amount = new Amount(100, false);
        assertEquals("1.00", amount.getAmount());
    }

    @Test
    public void testSingleEurosNegative() {
        Amount amount = new Amount(999, true);
        assertEquals("-9.99", amount.getAmount());
    }

    @Test
    public void testTenEurosPositive() {
        Amount amount = new Amount(1000, false);
        assertEquals("10.00", amount.getAmount());
    }

    @Test
    public void testTenEurosNegative() {
        Amount amount = new Amount(9999, true);
        assertEquals("-99.99", amount.getAmount());
    }

    @Test
    public void testHundredEurosPositive() {
        Amount amount = new Amount(10000, false);
        assertEquals("100.00", amount.getAmount());
    }

    @Test
    public void testHundredEurosNegative() {
        Amount amount = new Amount(99999, true);
        assertEquals("-999.99", amount.getAmount());
    }

    @Test
    public void testThousandEurosPositive() {
        Amount amount = new Amount(100000, false);
        assertEquals("1000.00", amount.getAmount());
    }

    @Test
    public void testThousandEurosNegative() {
        Amount amount = new Amount(999999, true);
        assertEquals("-9999.99", amount.getAmount());
    }

    // formWholeAmount() tests
    @Test
    public void testGetWholeAmountCentsOverNine() {
        Amount amount = new Amount(110, false);
        assertEquals("1.10", amount.formAmount(110, false));
    }

    @Test
    public void testGetWholeAmountCentsUnderTen() {
        Amount amount = new Amount(109, false);
        assertEquals("1.09", amount.formAmount(109, false));
    }

    // add() tests
    @Test
    public void testAddPositive() {
        Amount amount = new Amount(0, false);
        amount.add(100);
        assertEquals("1.00", amount.getAmount());
    }

    @Test
    public void testAddNegative() {
        Amount amount = new Amount(0, false);
        amount.add(-1);
        assertEquals("-0.01", amount.getAmount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCentsOverHundred() {
        Amount amount = new Amount(0, false);
        amount.add(1000000);
    }

    // Getter tests
    @Test
    public void testGetCents() {
        Amount amount = new Amount(230, false);
        assertEquals(230, amount.getCents());
    }

    @Test
    public void testGetAmount() {
        Amount amount = new Amount(230, false);
        assertEquals("2.30", amount.getAmount());
    }

    @Test
    public void testGetIsNegative() {
        Amount amount1 = new Amount(10, true);
        assertEquals(true, amount1.getIsNegative());
        Amount amount2 = new Amount(10, false);
        assertEquals(false, amount2.getIsNegative());
    }
}
