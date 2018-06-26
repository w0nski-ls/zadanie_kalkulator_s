package ls.recruitment.calculator.rate.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.exception.RateServiceException;
import org.springframework.web.client.RestTemplate;

@RunWith(MockitoJUnitRunner.class)
public class DefaultRateSupplierTest {

	private String VALID_URI = "http://api.nbp.pl/api/exchangerates/rates/a/%s/last/1/?format=json";
	private String INVALID_URI = "h1ttp://api.nbp.pl/api/exchangerates/rates/a/%s/last/1/?format=json";

	@Mock
	private RestTemplate restTemplate;
	
	@Test(expected = RateServiceException.class)
	public void shouldThrowAnExceptionWhenCurrencyIsNull() throws Exception {
		String nullCurrency = null;
		Integer randomWorkDaysCount = 22;				
		CalculatorConfig config = createCalculatorConfig(randomWorkDaysCount, VALID_URI);
		new DefaultRateSupplier(nullCurrency, config, restTemplate).getRate();
	}
	
	@Test(expected = RateServiceException.class)
	public void shouldThrowAnExceptionWhenCurrencyIsNotNullAndUriIsInvalid() throws Exception {
		String gbpCurrency = "GBP";
		Integer randomWorkDaysCount = 22;				
		CalculatorConfig config = createCalculatorConfig(randomWorkDaysCount, INVALID_URI);
		new DefaultRateSupplier(gbpCurrency, config, restTemplate).getRate();
	}

	private CalculatorConfig createCalculatorConfig(int workdaysCount,
			String uri) {
		CalculatorConfig config = new CalculatorConfig();
		config.setWorkdaysCount(workdaysCount);
		config.setUri(uri);

		return config;

	}

}
