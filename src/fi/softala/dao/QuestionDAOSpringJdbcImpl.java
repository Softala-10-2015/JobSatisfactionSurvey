/**
* @author Jukka, Samuli
*/

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

import fi.softala.bean.Question;

public class QuestionDAOSpringJdbcImpl {
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveQuestion(Question question) {
		final String sql = "insert into Question(survey_id, question_type, question_text, question_order) values (?,?,?,?)"; //Kysymykseen liittyv�t attribuutit asianmukaiseen tietokantatauluun
		final int surveyId = question.getSurvey_id();
		final int questionType=question.getQuestion_type();
		final String questionText=question.getQuestion_text();
		final int questionOrder=question.getQuestion_order();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "question_id" }); //Luo uudelle kysymykselle oman id:n
				ps.setInt(1, surveyId); //tallennetaan kysymykseen liittyv�t attribuutit
				ps.setInt(2, questionType);
				ps.setString(3, questionText);
				ps.setInt(4, questionOrder);
				return ps;
			}
		}, idHolder);
		question.setQuestion_id(idHolder.getKey().intValue());
	}
	
	public Question getOneQuestion(int questionId) { //Metodi, jolla haetaan yksi kysymys kerrallaan tietokantataulusta
		String sql = "select survey_id, question_type, question_text, question_order from question where question_id=?";
		Object[] parameters = new Object[] { questionId };
		RowMapper<Question> mapper = new QuestionRowMapper();
		Question wanted = new Question();
		try {
			wanted=jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			
		}
		return wanted;
	}
	
	public List<Question> getAllQuestions() { //Metodi, jolla haetaan kaikki kysymykset tietokantataulusta
		String sql = "select question_id, survey_id, question_type, question_text, question_order from question";
		RowMapper<Question> mapper = new QuestionRowMapper();
		List<Question> allQuestions = jdbcTemplate.query(sql, mapper);
		return allQuestions;
	}
}
