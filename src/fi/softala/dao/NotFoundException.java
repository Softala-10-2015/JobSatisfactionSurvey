package fi.softala.dao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Aleksi & Harri
 * 
 * Käytetään DAO:ssa, kun haetaan ID:n perusteella olioita.
 *
 */
@SuppressWarnings("serial")
@ResponseStatus(value=HttpStatus.NOT_FOUND)

public class NotFoundException extends RuntimeException{
	public NotFoundException(Exception e) {
		super(e);
	}
}
