package ls.recruitment.calculator.model;


public class Country {

	private String code;

	private String currency;

	private Double tax;

	private Double cost;

	public Country() {
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", currency=" + currency + ", tax="
				+ tax + ", cost=" + cost + "]";
	}
}
