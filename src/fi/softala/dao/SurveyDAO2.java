package fi.softala.dao;
import java.util.List;

import fi.softala.bean.Survey;

/**
 * Interface to SurveyJdbcDao
 * @author Pasi Lehmusvuori
 * 
 * @TODO
 * 	public void updateSurvey(Survey survey);
	public void publishSurvey(int survey_id);
	public void getSurveyByID(int survey_id);
	public void getAllSurveys();
 *
 */
public interface SurveyDAO2 {
	public void insertSurvey(Survey survey);
	<Question> List<Question> getById(int surveyId);
}
