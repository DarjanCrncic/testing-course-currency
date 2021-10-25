package guru.springframework;

public class Money implements Expression {

	protected int amount;
	protected String currency;
	
	protected Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public String currency() {
		return currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	@Override
	public Expression times(int multiplier) {
		return new Money(this.amount * multiplier, currency);
	}
	
	@Override
	public Expression plus(Expression addend) {
		return new Sum(this, addend);
	}
	
	@Override
	public Money reduce(Bank bank, String to) {
		return new Money(amount / bank.rate(this.currency, to), to);
	}

	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		Money money = (Money) object;
		if (this.currency() != money.currency()) {
			return false;
		}
		return this.amount == money.amount;
	}

	@Override
	public String toString() {
		return "Money [amount=" + amount + ", currency=" + currency + "]";
	}
	
}
