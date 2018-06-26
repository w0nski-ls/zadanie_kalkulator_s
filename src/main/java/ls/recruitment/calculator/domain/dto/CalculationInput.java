package ls.recruitment.calculator.domain.dto;

import ls.recruitment.calculator.model.Country;

public class CalculationInput {

	private Country country;

	private Double value;

	public CalculationInput() {
	}

	public CalculationInput(Country country, Double value) {
		this.country = country;
		this.value = value;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

}
