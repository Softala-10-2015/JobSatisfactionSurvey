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
import org.springframework.stereotype.Repository;

import fi.softala.bean.Answer;
import fi.softala.bean.Question;

@Repository
public class AnswerDAOSpringJdbcImpl implements AnswerDAO{
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
		
		if(answer.getQuestionId() != 0 && answer.getAnswerText() != null){
			final int questionId = answer.getQuestionId();
			final String answerText=answer.getAnswerText();
			//System.out.println("VASTAUSTEKSTI!! = "+answerText);
			KeyHolder idHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql,
							new String[] { "answer_id" });
					ps.setInt(1, questionId);
					ps.setString(2, answerText);
					return ps;
				}
			}, idHolder);
			answer.setAnswerId(idHolder.getKey().intValue());
		}
	}
	
	public Answer getOneAnswer(int answerId) {
		String sql = "select question_id, answer_text from Answer where answer_id=?";
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
		String sql = "select answer_id, question_id, answer_text from Answer";
		RowMapper<Answer> mapper = new AnswerRowMapper();
		List<Answer> allAnswers = jdbcTemplate.query(sql, mapper);
		return allAnswers;
	}
	
	public List<Answer> getAnswersForQuestion(int questionId) {
		String sql = "SELECT Answer.achoice_id, Answer.answer_id, Answer.answer_text, "
				+ "AnswerChoice.achoice_text"
				+ "FROM Answer"
				+ "LEFT JOIN AnswerChoice "
				+ "ON Answer.achoice_id=AnswerChoice.achoice_id "
				+ "LEFT JOIN Question ON AnswerChoice.question_id = Question.question_id "
				+ "WHERE question_id = ? "
				+ "ORDER BY answer_id;";
		
		Object[] params = new Object[] { questionId };
		System.out.println(params[0]);
		RowMapper<Answer> mapper = new AnswerRowMapper();
		
		List<Answer> answers= jdbcTemplate.query(sql, params, mapper);

		return answers;
	}
}
