package ls.recruitment.calculator.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.domain.ServiceOutput;
import ls.recruitment.calculator.domain.dto.CalculationOutput;
import ls.recruitment.calculator.exception.RateServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value = { "/calculator" })
public class CalculatorController {

	private static final Logger logger = LoggerFactory
			.getLogger(CalculatorController.class);

	@Autowired
	private CalculatorConfig config;

	@Autowired
	private CalculationService service;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ServiceOutput> calculate(
			@RequestParam(value = "value", required = true) Double value) {

		logger.debug(config.toString());
		if (value == null)
			return ResponseEntity.badRequest().body(
					new ServiceOutput("Nieprawidłowa stawka dzienna"));
		logger.debug("calculate: " + value);
		try {
			List<CalculationOutput> result = service.calculate(value);
			return ResponseEntity.ok().body(new ServiceOutput(result));
		} catch (RateServiceException rse) {
			return ResponseEntity.badRequest().body(
					new ServiceOutput(rse.getMessage()));
		}
	}
}
