package uz.xtreme.defaultstarter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private final String appMessage;

	public ObjectNotFoundException(String appMessage) {
		super(appMessage);
		this.appMessage = appMessage;
	}

}
