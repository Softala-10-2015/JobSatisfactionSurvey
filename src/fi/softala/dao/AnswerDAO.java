package fi.softala.dao;

import java.util.List;
import fi.softala.bean.Answer;



/** @author Jukka, Pasi, Kytis, Olli, Pipsa
*/


public interface AnswerDAO{
	
	public abstract void saveAnswer(Answer answer);
	
	public abstract List<Answer> getAnswersForSurvey(int surveyId);

}
