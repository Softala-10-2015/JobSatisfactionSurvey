package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Survey;

public interface SurveyDao {
	
	//interface suunnittelua ja toteutusta vaille valmis

	public abstract Survey findSurvey(int i);

	public abstract List<Survey> findSurveys();
	
	public abstract void addSurvey(Survey newSurvey);
	
	
}
