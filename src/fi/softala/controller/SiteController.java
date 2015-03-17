package fi.softala.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Survey;
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
		List<Survey> surveyList = dao.FindSurveys(0);
		System.out.println("surveys:" + surveyList);
		model.addAttribute("surveys", surveyList);
		
		return "home";
	}
	
}