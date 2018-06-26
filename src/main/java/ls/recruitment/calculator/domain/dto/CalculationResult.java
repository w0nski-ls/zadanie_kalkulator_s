package ls.recruitment.calculator.domain.dto;

public class CalculationResult extends CalculationOutput {

	private Double result;

	public CalculationResult(String currency, Double result) {
		super(currency);
		this.result = result;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

}