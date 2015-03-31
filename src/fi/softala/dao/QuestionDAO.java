/**
* @author Jukka, Samuli
*/

package fi.softala.dao;

import java.util.List;

import fi.softala.bean.AChoice;
import fi.softala.bean.Question;

public interface QuestionDAO{
	
	public abstract void saveQuestion(Question question);
	
	public abstract Question getOneQuestion(int questionId);
	
	public abstract List<Question> getAllQuestions();
	
	/**
	 * Hakee kysymykset kyselyn id:n perusteella.
	 * @param surveyId
	 * @return
	 */
	public abstract List<Question> getQuestionsForSurvey(int surveyId);
	
	public abstract void addAnswerChoice(AChoice answeChoice);

}
