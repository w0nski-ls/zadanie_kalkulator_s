package ls.recruitment.calculator.exception;


public class RateServiceException extends RuntimeException {

	public RateServiceException() {
	}

	public RateServiceException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RateServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public RateServiceException(String message) {
		super(message);
	}

	public RateServiceException(Throwable cause) {
		super(cause);
	}

}
