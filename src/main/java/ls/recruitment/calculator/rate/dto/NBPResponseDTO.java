package ls.recruitment.calculator.rate.dto;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import ls.recruitment.calculator.exception.RateException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NBPResponseDTO {

	@JsonProperty("rates")
	private List<Rate> rates;

	private String code;

	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	public Double getCurrentRate() throws RateException {
		if (CollectionUtils.isEmpty(rates)) {
			throw new RateException();
		}
		return rates.get(0).getMid();

	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public static class Rate {
		private Double mid;

		public Double getMid() {
			return mid;
		}

		public void setMid(Double mid) {
			this.mid = mid;
		}
	}
}
