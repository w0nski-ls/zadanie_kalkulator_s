package ls.recruitment.calculator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties
public class CalculatorConfig {

	@Value("${calculator.workdaysCount}")
	private Integer workdaysCount;

	@Value("${calculator.uri}")
	private String uri;

	public CalculatorConfig() {
	}

	public Integer getWorkdaysCount() {
		return workdaysCount;
	}

	public void setWorkdaysCount(Integer workdaysCount) {
		this.workdaysCount = workdaysCount;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	@Override
	public String toString() {
		return "CalculatorConfig [workdaysCount=" + workdaysCount + ", uri="
				+ uri + "]";
	}
}