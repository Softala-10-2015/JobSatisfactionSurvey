package fi.softala.dao;

import java.util.List;

import fi.softala.bean.Survey;

public interface SurveyDao {
	
	//interface suunnittelua ja toteutusta vaille valmis
	
	public abstract List<Survey> HaeKyselyt(int i);
	
	
}
