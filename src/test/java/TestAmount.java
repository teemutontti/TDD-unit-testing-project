package test.java;

import org.junit.*;
import main.java.Amount;

public class TestAmount {

    // Constructor tests
    @Test(expected = IllegalArgumentException.class)
    public void testEurosOverTenThousand() {
        new Amount(10001,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testEurosUnderZero() {
        new Amount(-1,0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCentsOverHundred() {
        new Amount(1,100);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCentsUnderZero() {
        new Amount(1,-1);
    }
    @Test
    public void testCorrectAmount() {
        Amount amount = new Amount(1,99);
        Assert.assertNotNull(amount);
    }

    // formWholeAmount() tests
    @Test
    public void testGetWholeAmountCentsOverNine() {
        Amount amount = new Amount(1, 10);
        Assert.assertEquals("1.10 €", amount.formWholeAmount(1,10));
    }
    @Test
    public void testGetWholeAmountCentsUnderTen() {
        Amount amount = new Amount(1, 9);
        Assert.assertEquals("1.09 €", amount.formWholeAmount(1,9));
    }

    // getEuros() tests
    @Test
    public void testGetEuros() {
        Amount amount = new Amount(2, 30);
        Assert.assertEquals(2, amount.getEuros());
    }

    // getCents() tests
    @Test
    public void testGetCents() {
        Amount amount = new Amount(2, 30);
        Assert.assertEquals(30, amount.getCents());
    }

    // getAmount() tests
    @Test
    public void testGetAmount() {
        Amount amount = new Amount(2, 30);
        Assert.assertEquals("2.30 €", amount.getAmount());
    }
}
