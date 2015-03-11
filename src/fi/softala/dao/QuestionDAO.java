/**
* @author Jukka, Samuli
*/

package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Question;

public interface QuestionDAO{
	
	public abstract void saveQuestion(Question question);
	
	public abstract Question getOneQuestion(int questionId);
	
	public abstract List<Question> getAllQuestions();	

}
