package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Survey;

public interface SurveyDao {
	
	//interface suunnittelua ja toteutusta vaille valmis

	public abstract Survey FindSurvey(int i);

	public abstract List<Survey> FindSurveys(int i);
	
	public abstract void addSurvey(Survey newSurvey);
	
	
}
