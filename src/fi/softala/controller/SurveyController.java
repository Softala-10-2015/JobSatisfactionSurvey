package fi.softala.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fi.softala.bean.AChoice;
import fi.softala.bean.Answer;
import fi.softala.bean.AnswerListWrapper;
import fi.softala.bean.Question;
import fi.softala.bean.QuestionListWrapper;
import fi.softala.bean.Survey;
import fi.softala.dao.AnswerDAO;
import fi.softala.dao.DaoConnectionException;
import fi.softala.dao.QuestionDAO;
import fi.softala.dao.SurveyDao;


/**
 * @author Aleksi Tilli, Pasi, Jukka, Olli, Samuli, Topi, Juha Palmu, Harri, Erik, Petri, Pipsa, Mikot, Markus
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
	
	public QuestionDAO getQuestionDAO() {
		return this.qDao;
	}
	
	public void setQuestionDAO(QuestionDAO dao) {
		this.qDao = dao;
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
		Survey survey = sDao.findSurvey(id);
		model.addAttribute("survey", survey);

		List<Question> questions = qDao.getQuestionsForSurvey(id);

		model.addAttribute("questions", questions);
		
		//lisätään tyhjä lista vastauksille
		model.addAttribute("answers", new AnswerListWrapper());
		
		return "survey";
	}
	
	@RequestMapping(value="confirmation", method=RequestMethod.GET)
	public String confirmation(){
		
		return "confirmation";
	}
	
	//vastausten tallentaminen
	@RequestMapping (value="get-survey/{id}", method=RequestMethod.POST)
	public String saveAnswer(@PathVariable Integer id, @Valid @ModelAttribute(value="answers") AnswerListWrapper answers, BindingResult result, Model model) {
		System.out.println("get-survey/{id} POST");
		
		if (result.hasErrors()) {
			Survey survey = sDao.findSurvey(id);
			model.addAttribute("survey", survey);

			List<Question> questions = qDao.getQuestionsForSurvey(id);
			model.addAttribute("questions", questions);

			return "survey";
		} else {
			for(Answer answer : answers.getAnswerList()) {
				System.out.println(answer.getAnswerText() + " " + answer.getQuestionId());
				aDao.saveAnswer(answer);
			}
			return "redirect:/survey/confirmation";
		}

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
	//listaa kysymykset
	@RequestMapping(value="get-all-questions", method=RequestMethod.GET)
	public String getAllQuestions(Model model) {
		List<Question> questions = qDao.getAllQuestions();
		model.addAttribute("questions", questions);
		return "summary";
	}
	//editoi kyselyn kysymyksiä
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editableSurveys(Model model){
		List<Survey> surveyList = sDao.findSurveys();
		model.addAttribute("surveys", surveyList);
		return "editSurvey/list";
	}
	//muokkaa kyselyitä
	@RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable Integer id, Model model){
		System.out.println(sDao.ifHasAnswers(id));
		//muokkaa vaan jos vastauksia ei ole
		if (sDao.ifHasAnswers(id)==false) {
			System.out.println(aDao.getAnswersForSurvey(id));
			Survey survey = sDao.findSurvey(id);
			survey.setQuestions(qDao.getQuestionsForSurvey(survey.getSurveyId()));
			model.addAttribute("survey", survey);
			return "editSurvey/edit";
		}else{
			List<String> errors = new ArrayList<String>();
			errors.add("Et voi muokata kyselyä jossa on jo vastauksia");
			model.addAttribute("errors" , errors);
			return "error";
		}	
	}
	//Kysymyksen järjestys
	@RequestMapping(value = "edit/editQuestion/{id}", method = RequestMethod.GET)
	public String editQuestion(@PathVariable Integer id, Model model) {
		Question q = new Question();
		q.setSurveyId(qDao.getOneQuestion(id).getSurveyId());
		q.setQuestionId(qDao.getOneQuestion(id).getQuestionId());
		q.setQuestionText(qDao.getOneQuestion(id).getQuestionText());
		q.setQuestionOrder(qDao.getOneQuestion(id).getQuestionOrder());
		q.setQuestionType(qDao.getOneQuestion(id).getQuestionType());
		System.out.println(q.toString());
		model.addAttribute("question", q);
		return "insertQuestion/editQuestion";
	}
	
	//Yksittäisen kysymyksen muokkaus
	@RequestMapping(value = "edit/editQuestion/{id}", method = RequestMethod.POST)
	public String sendEditedQuestion(@ModelAttribute(value = "question") Question q, @PathVariable Integer id) {
		System.out.println(q.toString());
		q.setQuestionId(id);
		qDao.editQuestion(q);
		System.out.println(q.toString());
		return "redirect:/survey/edit/" + q.getSurveyId();
	}
	//kysymyksen poisto
	@RequestMapping(value = "edit/{sId}/deleteQuestion/{qId}", method = RequestMethod.GET)
	public String deleteQuestionConfirmation(@PathVariable Integer sId, @PathVariable Integer qId, Model model) {
		Question q = qDao.getOneQuestion(qId);
		System.out.println("SurveyController: deleteQuestion");
		model.addAttribute("surveyId", sId);
		model.addAttribute("question", q);
		return "deleteQuestion/confirmation";
	}
	//kysymyksen poisto
	@RequestMapping(value = "edit/{sId}/deleteQuestion/{qId}", method = RequestMethod.POST)
	public String deleteQuestion(@PathVariable Integer sId, @PathVariable Integer qId, Model model) {
		Question q = new Question();
		qDao.deleteQuestion(qId);
		return "redirect:/survey/edit/" + sId;
	}
	//Kysymyksen luonti
	@RequestMapping(value = "edit/insertQuestion/{id}", method = RequestMethod.GET)
	public String addQuestion(@PathVariable Integer id, Model model) {
		Question q = new Question();
		q.setSurveyId(id);

		model.addAttribute("question", q);
		return "insertQuestion/createForm";
	}
	//Kysymyksen luonti
	@RequestMapping(value = "edit/insertQuestion/{id}", method = RequestMethod.POST)
	public String sendQuestion(@ModelAttribute(value = "question") Question q) {
		qDao.saveQuestion(q);
		return "redirect:/survey/edit/" + q.getSurveyId();
	}

	
	//Kyselyn luonti
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createInit(Model model, HttpSession session) {
		List<Survey> surveys = sDao.findSurveys();
		model.addAttribute("surveys", surveys);
		
		List<Question> questions = (ArrayList<Question>)session.getAttribute("questions");
		if(questions != null && !questions.isEmpty()) {
			model.addAttribute("questions", questions);
		}
		
		Survey s = (Survey)session.getAttribute("survey");
		if(s == null) {
			s = new Survey();
		}
		
		model.addAttribute("survey", s);
		model.addAttribute("question", new Question());
		return "create";
	}
	//kyselyn luonti
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String sendSurvey(@Valid @ModelAttribute(value = "survey") Survey s, BindingResult result, @ModelAttribute(value = "question") Question q,Model model, HttpSession session) {
		
		if (result.hasErrors()) {
			return "create";
		}else{

			List<Question> questions = (ArrayList<Question>)session.getAttribute("questions");
			if(questions != null && !questions.isEmpty()) {
				s.setQuestions(questions);
			}
			System.out.println("test");
			sDao.addSurvey(s);
			int lastId = sDao.findLastId();
			
			if(questions != null && !questions.isEmpty()) {
				for(Question qq : questions) {
					qq.setSurveyId(lastId);
					qDao.saveQuestion(qq);
				}
			}
			
			if(session.getAttribute("survey") != null) {
				System.out.println("Removing session attribute survey.");
				session.removeAttribute("survey");
			}
			
			if(session.getAttribute("questions") != null) {
				System.out.println("Removing session attribute questions.");
				session.removeAttribute("questions");
	
			}
			
			return "redirect:/survey/createConfirmation/" + lastId;
		}
	}
	
	@RequestMapping(value = "createConfirmation/{id}", method = RequestMethod.GET)
	public String sendSurvey(@PathVariable Integer id, Model model) {
		model.addAttribute("id", id);
		
		return "createConfirmation";
	}
	
	
	//valintakysymys
	@RequestMapping(value = "choice", method = RequestMethod.GET)
	public String addChoiceQuestion(Model model){
		model.addAttribute("questions", new QuestionListWrapper());
		return "choice";
	}
	//valinnan tallennus
	@RequestMapping(value = "choice", method = RequestMethod.POST)
	public String saveChoiceQuestion(@ModelAttribute(value = "questions") QuestionListWrapper q, Model model){
		
		for (int i = 0; i < q.getAcList().size(); i++) {
			System.out.println(q.getAcList().get(i).getaChoiceText());
		}
		return "redirect:/survey/choice";
	}
	//vastausten listaus
	@RequestMapping(value = "answers/{id}", method = RequestMethod.GET)
	public String viewAnswers(@PathVariable Integer id, Model model){
		Survey survey = sDao.findSurvey(id);
		survey.setAnswers(aDao.getAnswersForSurvey(survey.getSurveyId()));
		model.addAttribute("survey", survey);
		return "viewAnswers/answers";
	}

	//Kyselyiden listaus vastausten tarkastelua varten
	@RequestMapping(value = "surveylist", method = RequestMethod.GET)
	public String viewableAnswers(Model model){
		List<Survey> surveyList = sDao.findSurveys();
		model.addAttribute("surveys", surveyList);
		return "viewAnswers/list";
	}
	//kyselyiden listaus vastaamista varten
	@RequestMapping(value = "surveys", method = RequestMethod.GET)
	public String getSurveys(Model model){
		
		List<Survey> surveyList = sDao.findSurveys();
		model.addAttribute("surveys", surveyList);
		
		return "surveys";
	}

	@ModelAttribute("survey")
	public Survey getSurvey() {
		Survey survey = new Survey();
		return survey;
	}
	
	/**
	 * Lisää kyselyyn kysymyksen, käytetään ajaxin avulla. Lisää parametrinä saadun kysymyksen sessiossa sijaitsevaan listaan.
	 * @param question	lisättävä kysymys
	 * @return
	 */
	@RequestMapping(value = "ajax/addQuestion", method = RequestMethod.POST)
	public String addQuestionToSurvey(@ModelAttribute ("question") Question question, 
			ModelMap model, HttpSession session) {
	
		System.out.println("ajax/addQuestion POST");
		
		System.out.println(question.toString());
		List<Question> questions;
		if(session.getAttribute("questions") == null) {
			questions = new ArrayList<Question>();
		} else {
			questions = (ArrayList<Question>)session.getAttribute("questions");
		}
		
		System.out.println(question.toString());
		if(questions != null && !questions.isEmpty()) {
			int lastQuestionOrder = 0;
			for(Question q : questions) {
				lastQuestionOrder = q.getQuestionOrder();
			}
			question.setQuestionOrder(lastQuestionOrder + 1);
		} else {
			question.setQuestionOrder(1);
		}
		
		questions.add(question);
		
		session.setAttribute("questions", questions);
		model.addAttribute("questions", questions);

		return "redirect:/survey/ajax/viewQuestions";
	}
	
	/**
	 * Metodi ajaxia varten, palauttaa sessiosta listan kysymyksiä.
	 * @return	palauttaa ajax/viewQuestions.jsp-sivulle
	 */
	@RequestMapping(value = "ajax/viewQuestions", method = RequestMethod.GET)
	public String viewQuestions(ModelMap model, HttpSession session) {
		System.out.println("ajax/viewQuestions GET");
		ArrayList<Question> questions = (ArrayList<Question>)session.getAttribute("questions");
		if(questions != null) {
			//List<Question> questions = survey.getQuestions();
			model.addAttribute("questions", questions);
		}
		
		return "ajax/viewQuestions";
	}
	
	/**
	 * Poistaa paramterinä saadun id:n perusteella kysymyksen sessiossa sijaitsevasta listalta.
	 * @param id	siirrettävän kysymyksen järjestysnumero
	 * @return		Palauttaa ajax/viewQuestions.jsp-sivulle.
	 */
	@RequestMapping(value = "ajax/deleteQuestion/{id}", method = RequestMethod.GET)
	//@ResponseBody
	public String deleteQuestionAjax(@PathVariable Integer id, ModelMap model, HttpSession session) {
		System.out.println("ajax/deleteQuestion/" + id + " GET");
		List<Question> questions = (ArrayList<Question>)session.getAttribute("questions");

		if(questions != null && !questions.isEmpty()) {
			
			Iterator<Question> qIterator = questions.iterator();
			while(qIterator.hasNext()) {
				Question q = qIterator.next();
				if(q.getQuestionOrder() == id) {
					qIterator.remove();
				}
			}
			for(int i = 0; i < questions.size(); i++) {
				questions.get(i).setQuestionOrder(i + 1);
			}
			model.addAttribute("questions", questions);
		}
		return "ajax/viewQuestions";
	}
	
	/**
	 * Metodi ajaxia varten, siirtää sessiossa sijaitsevan kysymyslistan kysymyksen paikkaa.
	 * @param id			Siirrettävän kysymyksen järjetysnumero
	 * @param direction		up/down
	 * @return				palauttaa ajax/viewQuestions.jsp-sivulle
	 */
	@RequestMapping(value = "ajax/moveQuestion/{direction}/{id}", method = RequestMethod.GET)
	//@ResponseBody
	public String moveQuestionUp(@PathVariable Integer id, @PathVariable String direction, ModelMap model, HttpSession session) {
		System.out.println("ajax/moveQuestion GET");
		System.out.println(direction);
		List<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
		
		
		Question tempQuestion = new Question();
		if(questions != null && !questions.isEmpty()) {
			int index = 0;
			
			//tarkistetaanko löytyykö id:llä (kysymyksen järjestyksellä) kysymys listalta
			for(int i = 0; i < questions.size(); i++) {
				if(questions.get(i).getQuestionOrder() == id) {
					index = i;
				}
			}
			
			if(questions.get(index) != null) {
				tempQuestion = questions.get(index);
				
		 		if(direction.equals("up")) {
		 			System.out.println("moving up");
		 			if(index != 0) {
						questions.remove(index);
						questions.add(index - 1, tempQuestion);
		 			}
				} else if(direction.equals("down")) {
					System.out.println("moving down");
					if(index + 1 < questions.size()) {
						questions.remove(index);
						questions.add(index + 1, tempQuestion);
					}
				}
			}

	 		for(int i = 0; i < questions.size(); i++) {
				questions.get(i).setQuestionOrder(i + 1);
			}
		}
	
		model.addAttribute("questions", questions);
		return "ajax/viewQuestions";
	}
	
	/**
	 * Ei käytössä vielä, kyselyn luontisivulla valintojen lisääminen monivalintakysymyksiin
	 */
	@RequestMapping(value = "ajax/addAnswerChoice/{id}/{choice}", method = RequestMethod.GET)
	public String addAnswerChoiceAjax(@PathVariable Integer id, @PathVariable String choiceStr, ModelMap model, HttpSession session) {
		System.out.println("ajax/moveQuestion GET");
		
		List<Question> questions = (ArrayList<Question>) session.getAttribute("questions");
		
		
		if(questions != null && !questions.isEmpty()) {
			if(questions.get(id) != null) {
				AChoice choice = new AChoice();
				
				choice.setaChoiceText(choiceStr);
				choice.setQuestionId(id);
				
				List<AChoice> choices = new ArrayList<AChoice>();
				if(questions.get(id).getChoices() != null && !questions.get(id).getChoices().isEmpty()) {
					questions.get(id).getChoices().add(choice);
				} else {
					choices.add(choice);
					questions.get(id).setChoices(choices);
				}
			}
		}
		return " ";
	}
	
	/**
	 * Palauttaa listan kyselyistä kyselyiden luontisivulle
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "getSurveys/{id}", method = RequestMethod.GET)
	public String getSurveyList(@PathVariable Integer id, ModelMap model, HttpSession session) {
		System.out.println("getSurveys GET");
		System.out.println(session.getAttributeNames());
		session.removeAttribute("questions");
		session.removeAttribute("survey");
		
		Survey survey = sDao.findSurvey(id);
		
		List<Question> questions = qDao.getQuestionsForSurvey(survey.getSurveyId());

		session.setAttribute("questions", questions);
		session.setAttribute("survey", survey);

		return "redirect:/survey/create";
	}
	

}

