package ls.recruitment.calculator.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.domain.ServiceOutput;
import org.springframework.http.ResponseEntity;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorControllerTest {

	private String EXPECTED_MESSAGE = "Nieprawidłowa stawka dzienna";

	@Mock
	private CalculatorConfig config;

	@Mock
	private CalculationService service;

	@InjectMocks
	private CalculatorController calculatorController;

	@Test
	public void shouldReturn404BadRequestWhenValueIsNull() {
		ResponseEntity<ServiceOutput> expected = calculatorController
				.calculate(null);
		assertNotNull(expected.getBody());

		ServiceOutput sOutput = expected.getBody();
		assertEquals(sOutput.getErrorMessage(), EXPECTED_MESSAGE);
		assertNull(sOutput.getCalculationOutputs());
	}

}
