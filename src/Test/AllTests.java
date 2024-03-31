package Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import MoneyTest.Money;
import MoneyTest.MoneyBag;

@RunWith(Suite.class)
@SuiteClasses({ MoneyTest.class, MoneyBagTest.class })
public class AllTests {

    @Test
    public void testBagSimpleAdd() {
        Money f12CHF = new Money(12, "CHF");
        Money f7USD = new Money(7, "USD");
        MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag expected = new MoneyBag(f12CHF, f12CHF);
        assertEquals(expected, f12CHF.add(fMB1));
    }

    @Test
    public void testSimpleBagAdd() {
        Money f12CHF = new Money(12, "CHF");
        Money f7USD = new Money(7, "USD");
        MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag expected = new MoneyBag(f12CHF, f7USD, f12CHF);
        assertEquals(expected, fMB1.add(f12CHF));
    }

    @Test
    public void testBagBagAdd() {
        Money f12CHF = new Money(12, "CHF");
        Money f14CHF = new Money(14, "CHF");
        Money f7USD = new Money(7, "USD");
        Money f21USD = new Money(21, "USD");
        MoneyBag fMB1 = new MoneyBag(f12CHF, f7USD);
        MoneyBag fMB2 = new MoneyBag(f14CHF, f21USD);
        MoneyBag expected = new MoneyBag(f12CHF, f7USD, f14CHF, f21USD);
        assertEquals(expected, fMB1.add(fMB2));
    }
}
