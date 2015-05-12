/**
 * @author Aleksi Tilli, Pasi, Jukka, Olli, Samuli, Topi, Juha Palmu, Harri, Erik, Petri, Pipsa, Mikot, Markus
 *
 */

package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Survey;

public interface SurveyDao {
	
	//interface suunnittelua ja toteutusta vaille valmis

	public abstract Survey findSurvey(int i);

	public abstract List<Survey> findSurveys();
	
	public abstract void addSurvey(Survey newSurvey);

	public abstract int findLastId();
	
	public abstract boolean ifHasAnswers(int surveyId);
	
	
}
