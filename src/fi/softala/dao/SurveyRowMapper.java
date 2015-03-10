package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.softala.bean.Survey;

public class SurveyRowMapper implements RowMapper<Survey> {
	
	
public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
	Survey s = new Survey();
	
	//dao olio
		s.setSurvey_id(rs.getInt("survey_id"));
		s.setOwner_id(rs.getInt("owner_id"));
		s.setEmail(rs.getString("email"));
		s.setSurvey_name(rs.getString("survey_name"));

	//end of dao olio
	
	/*
	//mock
		s.setSurvey_id(1);
		s.setOwner_id(21);
		s.setEmail("a@a.fi");
		s.setSurvey_name("asd");
		System.out.println("Mock olio luotu:"+s.toString());
	//end of mock
	*/
		
		//kommentti
	return s;
}
	
	
}
