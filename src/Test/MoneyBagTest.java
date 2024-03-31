package Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import MoneyTest.Money;
import MoneyTest.MoneyBag;

public class MoneyBagTest {
    private MoneyBag fMB1;
    private MoneyBag fMB2;

    @Before
    public void setUp() {
        Money f12CHF = new Money(12, "CHF");
        Money f14CHF = new Money(14, "CHF");
        Money f7USD = new Money(7, "USD");
        Money f21USD = new Money(21, "USD");
        fMB1 = new MoneyBag(f12CHF, f7USD);
        fMB2 = new MoneyBag(f14CHF, f21USD);
    }

    @Test
    public void testBagEquals() {
        assertTrue(!fMB1.equals(null));
        assertEquals(fMB1, fMB1);
        assertFalse(fMB1.equals(fMB2));
    }
}
