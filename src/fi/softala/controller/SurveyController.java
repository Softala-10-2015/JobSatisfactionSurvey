package fi.softala.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fi.softala.bean.Answer;
import fi.softala.bean.Question;
import fi.softala.bean.Survey;
import fi.softala.dao.AnswerDAO;
import fi.softala.dao.SurveyDao;


/**
 * @author Aleksi Tilli
 *
 */
@Controller
@RequestMapping (value="/survey")
public class SurveyController {
	@Inject
	private AnswerDAO aDao;
	/*@Inject
	private SurveyDao sDao;
	
	public AnswerDAO getAnswerDAO() {
		return this.aDao;
	}
	
	public void setSurveyDAO(AnswerDAO dao) {
		this.aDao = dao;
	}
	
	public SurveyDao getSurveyDao() {
		return this.sDao;
	}
	
	public void setDao(SurveyDao dao) {
		this.sDao = dao;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		return "survey";
	}
	

	//Hakee kyselyn kannasta ja tallentaa sen sessioon.
	@RequestMapping(value="get-survey/{id}", method=RequestMethod.GET)
	public String getSurvey(@PathVariable Integer id, Model model, RedirectAttributes redirectAttrs) {
		Survey survey = sDao.HaeKysely(id);
		redirectAttrs.addFlashAttribute("survey", survey);
		
		return "redirect:/survey/get-questions/" + id;
	}
	
	//Kyselyn kysymysten hakeminen kyselyn id:n perusteella
	@RequestMapping (value="get-questions/{id}", method=RequestMethod.GET)
	public String getQuestions(Model model) {
		Survey survey = (Survey)model.asMap().get("survey");
		List<Question> questions = sDao.getQuestions(survey);
		
		model.addAttribute(questions);
		//Tähän path oikeaan jsp-sivuun
		return "survey";
	}*/

	
	//vastauksen tallentaminen
	@RequestMapping (value="send-answer", method=RequestMethod.GET)
	public void saveAnswer(@ModelAttribute(value="answer") Answer answer) {
		aDao.saveAnswer(answer);
	}


	
	//Yksittäisen vastauksen hakeminen id:n perusteella
	@RequestMapping (value="get-single/{id}", method=RequestMethod.GET)
	public String getAnswer(@PathVariable Integer id, Model model) {
		Answer answer = aDao.getOneAnswer(id);
		model.addAttribute(answer);
		//Tähän path oikeaan jsp-sivuun
		return "survey";
	}
	
	//Kaikkien vastausten hakeminen
	@RequestMapping(value="get-all-answers", method=RequestMethod.GET)
	public String getAllAnswers(Model model) {
		List<Answer> answers = aDao.getAllAnswers();
		model.addAttribute("answers", answers);
		return "summary";
	}
}
