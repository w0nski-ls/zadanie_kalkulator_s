package ls.recruitment.calculator.domain;

import java.util.function.Function;

import ls.recruitment.calculator.domain.dto.CalculationInput;
import ls.recruitment.calculator.domain.dto.CalculationOutput;

public interface Calculator extends
		Function<CalculationInput, CalculationOutput> {

}