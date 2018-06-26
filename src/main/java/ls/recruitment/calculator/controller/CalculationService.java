package ls.recruitment.calculator.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;
import ls.recruitment.calculator.domain.Calculator;
import ls.recruitment.calculator.domain.dto.CalculationInput;
import ls.recruitment.calculator.domain.dto.CalculationOutput;
import ls.recruitment.calculator.model.CountriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculationService {

	@Autowired
	private CountriesRepository repository;

	@Autowired
	private Calculator calculator;

	public CalculationService() {
	}

	public List<CalculationOutput> calculate(Double value) {
		return CollectionUtils
				.emptyIfNull(repository.getCountries())
				.stream()
				.map(country -> calculator.apply(new CalculationInput(country,
						value))).collect(Collectors.toList());
	}
}
