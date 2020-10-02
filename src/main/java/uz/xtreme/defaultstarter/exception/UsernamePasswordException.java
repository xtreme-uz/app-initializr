package uz.xtreme.defaultstarter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UsernamePasswordException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UsernamePasswordException() {
		super();
	}

	public UsernamePasswordException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsernamePasswordException(String message) {
		super(message);
	}

	public UsernamePasswordException(Throwable cause) {
		super(cause);
	}
}
