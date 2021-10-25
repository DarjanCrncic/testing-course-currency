package guru.springframework;

import java.util.HashMap;
import java.util.Map;

public class Bank {

	private Map<Pair, Integer> rateMap = new HashMap<>();

	Money reduce(Expression source, String toCurrency) {
		return source.reduce(this, toCurrency);
	}

	public int rate(String from, String to) {
		Integer rate;
		if(from.equals(to)) {
			rate = 1;
		} else {
			rate = rateMap.get(new Pair(from, to));
		}
		return rate;
	}

	public void addRate(String from, String to, int rate) {
		rateMap.put(new Pair(from, to), rate);
	}
}
