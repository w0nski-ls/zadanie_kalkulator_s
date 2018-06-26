package ls.recruitment.calculator.rate;

import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.model.Country;
import ls.recruitment.calculator.rate.impl.DefaultRateSupplier;
import ls.recruitment.calculator.rate.impl.PLNRateSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RateSupplierFactory {

	private static final String PLN_CODE = "PLN";
	
	@Autowired
	private RestTemplate restTemplate;

	public RateSupplier getRateSupplier(Country country, CalculatorConfig config) {
		switch (country.getCurrency()) {
		case PLN_CODE:
			return new PLNRateSupplier();
		default:
			return new DefaultRateSupplier(country.getCurrency(), config, restTemplate);
		}
	}
}
