package fi.softala.dao;

import org.springframework.dao.DataAccessException;

/**
 * @author Aleksi & Harri
 *
 */
@SuppressWarnings("serial")
public class DaoConnectionException extends DataAccessException{
	public DaoConnectionException(String msg) {
		super(msg);
	}
	
	public DaoConnectionException(String msg, Exception e) {
		super(msg, e);
	}
}
