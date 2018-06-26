package ls.recruitment.calculator.model;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("model")
public class CountriesRepository {
	private List<Country> countries;

	public CountriesRepository() {
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}
}
