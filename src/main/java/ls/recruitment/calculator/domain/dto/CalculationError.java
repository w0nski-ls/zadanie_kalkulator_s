package ls.recruitment.calculator.domain.dto;

public class CalculationError extends CalculationOutput {
	private String message;

	public CalculationError(String currency, String message) {
		super(currency);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
