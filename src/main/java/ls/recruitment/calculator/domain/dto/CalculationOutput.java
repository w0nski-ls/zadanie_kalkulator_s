package ls.recruitment.calculator.domain.dto;

public class CalculationOutput {
	private String currency;

	public CalculationOutput(String currency) {
		this.currency = currency;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
