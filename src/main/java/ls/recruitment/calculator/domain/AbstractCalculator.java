package ls.recruitment.calculator.domain;

import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.exception.RateException;
import ls.recruitment.calculator.model.Country;
import ls.recruitment.calculator.rate.RateSupplier;
import ls.recruitment.calculator.rate.RateSupplierFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractCalculator implements Calculator {

	@Autowired
	private CalculatorConfig config;

	@Autowired
	private RateSupplierFactory factory;

	public CalculatorConfig getConfig() {
		return config;
	}

	protected Double getRate(Country country) throws RateException {
		RateSupplier rateSupplier = factory.getRateSupplier(country, config);
		return rateSupplier.getRate();
	}
}
