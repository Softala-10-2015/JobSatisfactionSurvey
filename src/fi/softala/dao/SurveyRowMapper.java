/**
 * @author Aleksi Tilli, Pasi, Jukka, Olli, Samuli, Topi, Juha Palmu, Harri, Erik, Petri, Pipsa, Mikot, Markus
 *
 */

package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import fi.softala.bean.Survey;

public class SurveyRowMapper implements RowMapper<Survey> {
	
	
public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
	Survey s = new Survey();
	
	//dao olio
		s.setSurveyId(rs.getInt("survey_id"));
		s.setOwnerId(rs.getInt("owner_id"));
		s.setSurveyName(rs.getString("survey_name"));
	
	
	return s;
}
	
	
}
