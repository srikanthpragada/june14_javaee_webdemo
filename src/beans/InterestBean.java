package beans;

public class InterestBean {
	private double amount, rate;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getInterest() {
		return  amount * rate / 100;
	}

	 

}
