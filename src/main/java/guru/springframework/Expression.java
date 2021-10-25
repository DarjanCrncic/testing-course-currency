package guru.springframework;

public interface Expression {

	Money reduce(Bank bank, String toCurrency);

	public Expression plus(Expression addend);
	
	public Expression times(int multiplier);
}
