package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Answer;

public interface AnswerDAO{
	
	public abstract void saveAnswer(Answer answer);
	
	public abstract Answer getOneAnswer(int answerId);
	
	public abstract List<Answer> getAllAnswers();	
	
	public abstract List<Answer> getAnswersForSurvey(int surveyId);

}
