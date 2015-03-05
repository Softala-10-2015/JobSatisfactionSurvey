package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fi.softala.bean.Answer;

public class AnswerDAOSpringJdbcImpl {
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveAnswer(Answer answer) {
		final String sql = "insert into Answer(question_id, answer_text) values (?,?)";
		final int questionId = answer.getQuestionId();
		final String answerText=answer.getAnswerText();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "answerId" });
				ps.setInt(1, questionId);
				ps.setString(2, answerText);
				return ps;
			}
		}, idHolder);
		answer.setAnswerId(idHolder.getKey().intValue());
	}
	
	public Answer getOneAnswer(int answerId) {
		String sql = "select question_id, answer_text from answer where answer_id=?";
		Object[] parameters = new Object[] { answerId };
		RowMapper<Answer> mapper = new AnswerRowMapper();
		Answer wanted = new Answer();
		try {
			wanted=jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			
		}
		return wanted;
	}
	
	public List<Answer> getAllAnswers() {
		String sql = "select answer_id, question_id, answer_text from answer";
		RowMapper<Answer> mapper = new AnswerRowMapper();
		List<Answer> allAnswers = jdbcTemplate.query(sql, mapper);
		return allAnswers;
	}
}
