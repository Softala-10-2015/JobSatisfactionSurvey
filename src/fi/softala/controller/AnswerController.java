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
import org.springframework.web.bind.annotation.RequestParam;

import fi.softala.bean.Answer;
import fi.softala.dao.AnswerDAO;


/**
 * @author Aleksi T
 *
 */
@Controller
@RequestMapping (value="/survey")
public class AnswerController {
	@Inject
	private AnswerDAO aDao;
//	@Inject
//	private SurveyDAO sDao;
	
	public AnswerDAO getAnswerDAO() {
		return this.aDao;
	}
	
	public void setSurveyDAO(AnswerDAO dao) {
		this.aDao = dao;
	}
	
//	public SurveyDao sDao getDao() {
//		return this.sDao;
//	}
//	
//	public void setDao(SurveyDao dao) {
//		this.sDao = dao;
//	}
//	
//	//Kaikkien  kysymysten hakeminen
//	@RequestMapping (value="get-questions", method=RequestMethod.GET)
//	public String getQuestions(Model model) {
//		//List<Question> questions = sDao.getAllQuestions();
//		Question q1 = new Question( , , ,);
//		Question q2 = new Question( , , ,);
//		Question q3 = new Question( , , ,);
//		ArrayList<Question> questions = new ArrayList<Question>();
//		questions.add(q1);
//		questions.add(q2);
//		questions.add(q3);
//		model.addAttribute(questions);
//		//Tähän path oikeaan jsp-sivuun
//		return "survey/survey";
//	}
	
	
	//vastauksen tallentaminen
	@RequestMapping (value="sendAnswer", method=RequestMethod.GET)
	public void saveAnswer(@ModelAttribute(value="answer") Answer answer) {
		aDao.saveAnswer(answer);
	}


	
	//Yksittäisen vastauksen hakeminen id:n perusteella
	@RequestMapping (value="get-single/{id}", method=RequestMethod.GET)
	public String getAnswer(@PathVariable Integer id, Model model) {
		Answer answer = aDao.getOneAnswer(id);
		model.addAttribute(answer);
		//Tähän path oikeaan jsp-sivuun
		return "survey/survey";
	}
	
	//Kaikkien vastausten hakeminen
	@RequestMapping(value="get-all", method=RequestMethod.GET)
	public String getAllAnswers(Model model) {
		List<Answer> answers = aDao.getAllAnswers();
		model.addAttribute("answers", answers);
		return "confirmation";
	}
}
