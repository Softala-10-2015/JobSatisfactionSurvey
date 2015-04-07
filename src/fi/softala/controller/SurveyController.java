package fi.softala.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.Answer;
import fi.softala.bean.AnswerListWrapper;
import fi.softala.bean.Question;
import fi.softala.bean.Survey;
import fi.softala.dao.AnswerDAO;
import fi.softala.dao.QuestionDAO;
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
	@Inject
	private QuestionDAO qDao;
	@Inject
	private SurveyDao sDao;
	
	public AnswerDAO getAnswerDAO() {
		return this.aDao;
	}
	
	public void setAnswerDAO(AnswerDAO dao) {
		this.aDao = dao;
	}
	
	public SurveyDao getSurveyDao() {
		return this.sDao;
	}
	
	public void setSurveyDao(SurveyDao dao) {
		this.sDao = dao;
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String getCreateForm(Model model) {
		System.out.println("SurveyController test");
		return "survey";
	}
	

	//Hakee parametrina saadun kyselyn id:n perusteella kysymykset kannasta.
	@RequestMapping(value="get-survey/{id}", method=RequestMethod.GET)
	public String getSurvey(@PathVariable Integer id, Model model) {
		System.out.println("get-survey/" + id);
		//haetaan kysely, jonka perusteella voidaan tuoda otsikko, tekijä jne.
			//Survey survey = sDao.FindSurvey(id);
			//model.addAttribute("survey", survey);

		List<Question> questions = qDao.getQuestionsForSurvey(id);

		model.addAttribute("questions", questions);
		
		//lisätään tyhjä lista vastauksille
		model.addAttribute("answers", new AnswerListWrapper());
		
		return "survey";
	}

	
	//vastausten tallentaminen
	@RequestMapping (value="get-survey/{id}", method=RequestMethod.POST)
	public String saveAnswer(@ModelAttribute(value="answers") /*List<Answer> answers*/ AnswerListWrapper answers) {
		System.out.println("get-survey/{id} POST");
		for(Answer answer : answers.getAnswerList()) {
			System.out.println(answer.getAnswerText() + " " + answer.getQuestionId());
			aDao.saveAnswer(answer);
		}
		return "redirect:/";
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

	@RequestMapping(value="get-all-questions", method=RequestMethod.GET)
	public String getAllQuestions(Model model) {
		List<Question> questions = qDao.getAllQuestions();
		model.addAttribute("questions", questions);
		return "summary";
	}

	// yksittäisen kysymyksen luonti(petellä on tylsää)
	@RequestMapping(value = "insertQuestion", method = RequestMethod.GET)
	public String getCreateFormQ(Model model) {
		Question q = new Question();
		q.setSurveyId(1);

		model.addAttribute("question", q);
		return "insertQuestion/createForm";
	}

	// yksittäisen kysymyksen käsittely(petellä on tylsää)
	@RequestMapping(value = "insertQuestion", method = RequestMethod.POST)
	public String createQ(@ModelAttribute(value = "question") Question q) {
		qDao.saveQuestion(q);
		return "insertQuestion/vahvistus";
	}

	// yksittäisen vastauksen luonti(petellä on tylsää)
	// kyssäri teksti bugaa jo dao tasolla -> etsi syylliset
	@RequestMapping(value = "insertAnswer/{id}", method = RequestMethod.GET)
	public String getCreateForma(@PathVariable Integer id, Model model) {
		Question question = qDao.getOneQuestion(id);
		Answer answer = new Answer();
		answer.setQuestionId(id);
		
		model.addAttribute("question",question);
		model.addAttribute("answer",answer);
		return "insertAnswer/createForm";
	}

	// yksittäisen vastauksen käsittely(petellä on tylsää)
	@RequestMapping(value = "insertAnswer/{id}", method = RequestMethod.POST)
	public String createA(@PathVariable Integer id, @ModelAttribute(value = "answer") Answer a) {
		
		a.setQuestionId(id);
		aDao.saveAnswer(a);
		return "insertAnswer/vahvistus";
	}

}
