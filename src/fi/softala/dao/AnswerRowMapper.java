package fi.softala.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import fi.softala.bean.Answer;

public class AnswerRowMapper implements RowMapper<Answer> {
	public Answer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Answer answer = new Answer();
		answer.setAnswerId(rs.getInt("answerId"));
		answer.setQuestionId(rs.getInt("questionId"));
		answer.setAnswerText(rs.getString("answerText"));
		
		return answer;
	}

}
