package ls.recruitment.calculator.domain.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ls.recruitment.calculator.domain.AbstractCalculator;
import ls.recruitment.calculator.domain.dto.CalculationError;
import ls.recruitment.calculator.domain.dto.CalculationInput;
import ls.recruitment.calculator.domain.dto.CalculationOutput;
import ls.recruitment.calculator.domain.dto.CalculationResult;
import ls.recruitment.calculator.exception.RateException;
import org.springframework.stereotype.Component;

@Component(value = "NetCalculator")
public class NetCalculator extends AbstractCalculator {

	private static final Logger logger = LoggerFactory
			.getLogger(NetCalculator.class);

	@Override
	public CalculationOutput apply(CalculationInput input) {
		String currency = input.getCountry().getCurrency();
		try {
			logger.debug("Calculating for: " + input);
			Double rate = getRate(input.getCountry());
			logger.debug("calculated rate: " + rate);
			Double result = calculate(rate, input);
			CalculationResult calcResult = new CalculationResult(currency,
					result);
			logger.debug("calculated rate: " + calcResult);
			return calcResult;
		} catch (RateException e) {
			return new CalculationError(currency, e.getMessage());
		}
	}

		private Double calculate(Double currencyRate, CalculationInput input) {
		Double netPerMonth = netPerMonth(input.getValue(), getConfig()
				.getWorkdaysCount());
		Double taxRate = 1.0 - input.getCountry().getTax() / 100.0;
		return (netPerMonth - input.getCountry().getCost()) * taxRate * currencyRate;

	}

	private Double netPerMonth(Double netPerDay, Integer workDaysCount) {
		return netPerDay * workDaysCount;
	}
}