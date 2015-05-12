package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Question;

/**
* @author Jukka, Samuli, pasi, Harri
*/

public class QuestionRowMapper implements RowMapper<Question> {
	public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
		Question question = new Question();
		question.setQuestionId(rs.getInt("question_id"));
		question.setSurveyId(rs.getInt("survey_id"));
		question.setQuestionType(rs.getInt("question_type"));
		question.setQuestionText(rs.getString("question_text"));
		question.setQuestionOrder(rs.getInt("question_order"));
		
		
		
		return question;
	}

}
