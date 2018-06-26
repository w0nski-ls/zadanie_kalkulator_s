package ls.recruitment.calculator.rate.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PLNRateSupplierTest {

	private Double EXPECTED_RATE = 1.0d;

	@Spy
	private PLNRateSupplier plnRateSupplier;

	@Test
	public void shouldAlwaysReturnOneAsRate() {
		System.out.println(plnRateSupplier.getRate());
		assertEquals(EXPECTED_RATE, plnRateSupplier.getRate());
	}

}
