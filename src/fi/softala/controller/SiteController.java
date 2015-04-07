package fi.softala.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fi.softala.bean.Question;
import fi.softala.bean.Survey;
import fi.softala.dao.DaoConnectionException;
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
	public String getSurveyList(Model model) {
		System.out.println("SiteController");
		try {
			List<Survey> surveyList = dao.findSurveys();
			System.out.println("surveys:" + surveyList);
			model.addAttribute("surveys", surveyList);
		} catch(DataAccessException e) {
			throw new DaoConnectionException("Tietokantaan ei saada yhteyttä.", e);
		}
		
		return "home";
	}
	
	
	@ExceptionHandler(DaoConnectionException.class)
	public String connectionNotEstablished(HttpServletRequest request, DaoConnectionException e) {
		System.out.println("Request " + request.getRequestURL() + " raised an exception: " + e);
		ModelAndView mav = new ModelAndView();
		mav.addObject("url", request);
		mav.addObject("exception", e.getMessage());
		
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
	
	
	/**
	 * @author Mikko Mattila
	 *
	 */
	
	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String home(Model model) {	
		//etusivu
		return "home";
	}
	
	@RequestMapping(value = "survey", method = RequestMethod.GET)
	public String surveyInit(Model model) {	
		//vastaamisen initialisointi
		return "survey";
	}
	
	@RequestMapping(value = "summary", method = RequestMethod.GET)
	public String summaryInit(Model model) {	
		//vastaukset
		return "summary";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createInit(Model model) {	
		//kyselyluonnin initialisointi
		return "create";
	}
	
	
	
}