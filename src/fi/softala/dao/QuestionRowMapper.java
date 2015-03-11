/**
* @author Jukka, Samuli
*/

package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Question;

public class QuestionRowMapper implements RowMapper<Question> {
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setQuestion_id(rs.getInt("question_id"));
		question.setSurvey_id(rs.getInt("survey_id"));
		question.setQuestion_type(rs.getInt("question_type"));
		question.setQuestion_text(rs.getString("question_text"));
		question.setQuestion_order(rs.getInt("question_order"));
		
		return question;
	}

}
