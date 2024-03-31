package MoneyTest;

public class Money implements IMoney {
    int amount;
    String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    @Override
    public IMoney add(IMoney aMoney) {
        return ((Money) aMoney).addMoney(this);
    }

    public IMoney addMoney(Money m) {
        if (m.currency.equals(currency)) {
            return new Money(amount + m.amount, currency);
        } else {
            return (IMoney) new MoneyBag(this, m);
        }
    }
}
