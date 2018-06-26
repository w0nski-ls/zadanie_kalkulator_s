package ls.recruitment.calculator.rate.impl;

import java.net.URI;
import java.net.URISyntaxException;

import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.exception.RateException;
import ls.recruitment.calculator.exception.RateServiceException;
import ls.recruitment.calculator.rate.RateSupplier;
import ls.recruitment.calculator.rate.dto.NBPResponseDTO;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class DefaultRateSupplier implements RateSupplier {

	private CalculatorConfig config;

	private String currency;
	
	private RestTemplate restTemplate;

	public DefaultRateSupplier(String currency, CalculatorConfig config, RestTemplate restTemplate) {
		this.currency = currency;
		this.config = config;
		this.restTemplate = restTemplate;
	}

	public Double getRate() throws RateException {
		URI uri = createRateServiceURI(currency);
		try {
			NBPResponseDTO result = restTemplate.getForObject(uri,
					NBPResponseDTO.class);
			return result.getCurrentRate();
		} catch (HttpClientErrorException ex) {
			throw new RateException(ex.getMessage());
		} catch (Exception ex) {
			throw new RateServiceException(ex.getMessage());
		}
	}

	private URI createRateServiceURI(String currency) throws RateServiceException {
		if(currency == null)
			throw new RateServiceException("Nie podano waluty");
		try {
			String url = config.getUri();
			URI uri = new URI(String.format(url, currency));
			return uri;
		} catch (URISyntaxException e) {
			throw new RateServiceException(e.getMessage());
		}
	}
}