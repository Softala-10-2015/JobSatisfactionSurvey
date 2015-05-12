package fi.softala.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Aleksi & Harri
 *
 */
@ControllerAdvice
public class DaoConnectionException {
	
	public static final String ERROR_VIEW = "error";
	
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView connectionNotEstablished(HttpServletRequest request, DataAccessException e) {
		System.out.println("Request " + request.getRequestURL() + " raised an exception: " + e);
		
		List<String> errors = new ArrayList<String>();
		errors.add("Tietokantaan ei saada yhteyttä");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request);
		mav.addObject("exception", e.getMessage());
		mav.addObject("errors", errors);
		mav.setViewName(ERROR_VIEW);
		
		return mav;
	}
}