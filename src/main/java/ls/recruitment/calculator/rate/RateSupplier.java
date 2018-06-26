package ls.recruitment.calculator.rate;

import ls.recruitment.calculator.exception.RateException;

public interface RateSupplier {
	Double getRate() throws RateException;
}
