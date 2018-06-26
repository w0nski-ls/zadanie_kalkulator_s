package ls.recruitment.calculator.exception;

public class RateException extends Exception {

	public RateException() {
		super();
	}

	public RateException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RateException(String message, Throwable cause) {
		super(message, cause);
	}

	public RateException(String message) {
		super(message);
	}

	public RateException(Throwable cause) {
		super(cause);
	}
}
