package fi.softala.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.dao.NotFoundException;
import fi.softala.dao.SurveyDao;

/**
 * @author Aleksi Tilli
 *
 */
@Controller
@RequestMapping(value="/")
public class SiteController {
	@Inject
	private SurveyDao dao;
	
	public SurveyDao getDao() {
		return this.dao;
	}
	
	public void setDao(SurveyDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getSurveyList() {
		return "home";
	}
	
	@ExceptionHandler (NotFoundException.class)
	public String objectNotFound(HttpServletRequest request, NotFoundException e) {
		System.out.println("Request " + request.getRequestURL() + " raised an exception: " + e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request);
		mav.addObject("exception", e.getMessage());
		
		return "home";
	}
}