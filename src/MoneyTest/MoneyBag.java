package MoneyTest;

import java.util.Vector;

public class MoneyBag implements IMoney {
    private Vector<Money> monies = new Vector<Money>();

    public MoneyBag(Money m1, Money m2) {
        appendMoney(m1);
        appendMoney(m2);
    }

    public MoneyBag(Money... monies) {
        for (Money m : monies) {
            appendMoney(m);
        }
    }

    private void appendMoney(Money m) {
        if (monies.isEmpty()) {
            monies.add(m);
        } else {
            int i = 0;
            while (i < monies.size() && !monies.get(i).currency.equals(m.currency)) {
                i++;
            }
            if (i >= monies.size()) {
                monies.add(m);
            } else {
                monies.set(i, new Money(monies.get(i).amount + m.amount, m.currency));
            }
        }
    }

    @Override
    public IMoney add(IMoney aMoney) {
        return ((MoneyBag) aMoney).addMoneyBag(this);
    }

    public IMoney addMoneyBag(MoneyBag bag) {
        Vector<Money> newMonies = new Vector<>(this.monies);
        for (Money m : bag.monies) {
            appendMoney(new Money(m.amount, m.currency));
        }
        return new MoneyBag(newMonies.toArray(new Money[0]));
    }
}
