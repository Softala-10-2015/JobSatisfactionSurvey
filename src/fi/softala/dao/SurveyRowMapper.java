package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.softala.bean.Survey;

public class SurveyRowMapper implements RowMapper<Survey> {
	
	
public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
	Survey s = new Survey();
	
	//Tähän listankäynti tietokannansta, lisäys yhteen Survey olioon!W
	
	//mock
	s.setSurvey_id(1);
	//end of mock
	
	return s;
}
	
	
}
