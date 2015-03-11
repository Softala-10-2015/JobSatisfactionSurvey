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
@RequestMapping(value="*")
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
//		List<Survey> surveyList = dao.getAllSurveys();
//		model.addAttribute("survey", surveyList);
		
		//testikoodia
		ArrayList<Survey> surveyList = new ArrayList();
		Survey survey1 = new Survey();
		survey1.setSurvey_id(1);
		survey1.setEmail("asd@asd.asd");
		survey1.setOwner_id(1);
		survey1.setSurvey_name("Testi kysely1");
		
		Survey survey2 = new Survey();
		survey1.setSurvey_id(2);
		survey1.setEmail("asd@asd.asd");
		survey1.setOwner_id(1);
		survey1.setSurvey_name("Testi kysely1");
		
		surveyList.add(survey1);
		surveyList.add(survey2);
		
		model.addAttribute(surveyList);
		System.out.println("SiteController");
		return "home";
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String selectSurvey(@ModelAttribute(value="survey") Survey survey) {		
		return "redirect:/survey/" + survey.getSurvey_id();
	}
	
}
