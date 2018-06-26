package ls.recruitment.calculator.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import ls.recruitment.calculator.config.CalculatorConfig;
import ls.recruitment.calculator.domain.dto.CalculationInput;
import ls.recruitment.calculator.domain.dto.CalculationOutput;
import ls.recruitment.calculator.domain.dto.CalculationResult;
import ls.recruitment.calculator.model.Country;
import ls.recruitment.calculator.rate.RateSupplier;
import ls.recruitment.calculator.rate.RateSupplierFactory;

@RunWith(MockitoJUnitRunner.class)
public class NetCalculatorTest {

	private static final String EXPECTED_CURRENCY = "GBP";

	@Mock
	private CalculatorConfig config;

	@Mock
	private RateSupplierFactory factory;

	@InjectMocks
	private NetCalculator netCalculator;

	@Test
	public void testForExpectedValue() throws Exception {

		Double expectedResult = 0.0;

		Country c = new Country();
		c.setCode("UK");
		c.setCost(600.0);
		c.setCurrency(EXPECTED_CURRENCY);
		c.setTax(19.0);

		RateSupplier rateSupplier = Mockito.mock(RateSupplier.class);
		Mockito.when(rateSupplier.getRate()).thenReturn(4.9281d);

		Mockito.when(factory.getRateSupplier(c, config)).thenReturn(
				rateSupplier);

		Mockito.when(config.getWorkdaysCount()).thenReturn(22);

		CalculationInput input = new CalculationInput(c,
				600.0 / config.getWorkdaysCount());

		CalculationOutput output = netCalculator.apply(input);

		assertTrue(CalculationResult.class.isAssignableFrom(output.getClass()));
		CalculationResult result = (CalculationResult) output;
		assertEquals(EXPECTED_CURRENCY, result.getCurrency());
		assertEquals(expectedResult, result.getResult());
	}

}
