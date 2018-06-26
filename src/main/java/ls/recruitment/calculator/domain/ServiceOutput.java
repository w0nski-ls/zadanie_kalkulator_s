package ls.recruitment.calculator.domain;

import java.util.List;

import ls.recruitment.calculator.domain.dto.CalculationOutput;

public class ServiceOutput {
	private String errorMessage;

	private List<CalculationOutput> calculationOutputs;

	public ServiceOutput() {
	}

	public ServiceOutput(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ServiceOutput(List<CalculationOutput> calculationOutputs) {
		this.calculationOutputs = calculationOutputs;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<CalculationOutput> getCalculationOutputs() {
		return calculationOutputs;
	}

	public void setCalculationOutputs(List<CalculationOutput> calculationOutputs) {
		this.calculationOutputs = calculationOutputs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((calculationOutputs == null) ? 0 : calculationOutputs
						.hashCode());
		result = prime * result
				+ ((errorMessage == null) ? 0 : errorMessage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ServiceOutput other = (ServiceOutput) obj;
		if (calculationOutputs == null) {
			if (other.calculationOutputs != null)
				return false;
		} else if (!calculationOutputs.equals(other.calculationOutputs))
			return false;
		if (errorMessage == null) {
			if (other.errorMessage != null)
				return false;
		} else if (!errorMessage.equals(other.errorMessage))
			return false;
		return true;
	}

}
