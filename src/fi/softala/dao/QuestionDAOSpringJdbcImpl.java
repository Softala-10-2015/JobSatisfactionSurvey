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
import org.springframework.stereotype.Repository;

import fi.softala.bean.Question;

@Repository
public class QuestionDAOSpringJdbcImpl implements QuestionDAO{
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
		final int survey_id = question.getSurvey_id();
		final int question_type=question.getQuestion_type();
		final String question_text=question.getQuestion_text();
		final int question_order=question.getQuestion_order();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "question_id" }); //Luo uudelle kysymykselle oman id:n
				ps.setInt(1, survey_id); //tallennetaan kysymykseen liittyv�t attribuutit
				ps.setInt(2, question_type);
				ps.setString(3, question_text);
				ps.setInt(4, question_order);
				return ps;
			}
		}, idHolder);
		question.setQuestion_id(idHolder.getKey().intValue());
	}
	
	public Question getOneQuestion(int question_id) { //Metodi, jolla haetaan yksi kysymys kerrallaan tietokantataulusta
		String sql = "select question_id, survey_id, question_type, question_text, question_order from Question where question_id=?";
		Object[] parameters = new Object[] { question_id };
		RowMapper<Question> mapper = new QuestionRowMapper();
		Question wanted = new Question();
		try {
			wanted=jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			
		}
		return wanted;
	}
	
	public List<Question> getAllQuestions() { //Metodi, jolla haetaan kaikki kysymykset tietokantataulusta
		String sql = "select question_id, survey_id, question_type, question_text, question_order from Question";
		RowMapper<Question> mapper = new QuestionRowMapper();
		List<Question> allQuestions = jdbcTemplate.query(sql, mapper);
		return allQuestions;
	}
	
	public List<Question> getQuestionsForSurvey(int surveyId) {
		String sql = "SELECT question_id, survey_id, question_type, "
				+ "question_text, question_order "
				+ "FROM Question "
				+ "WHERE survey_id = ? "
				+ "ORDER BY question_order;";
		
		Object[] params = new Object[] { surveyId };
		System.out.println(params[0]);
		RowMapper<Question> mapper = new QuestionRowMapper();
		
		//List<Question> questions = new ArrayList<Question>();
		//Question question;
		List<Question> questions= jdbcTemplate.query(sql, params, mapper);
//		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql, new Object[] {1});
//		for(Map row : rows) {
//			Question q = new Question();
//			q.setQuestion_id((Integer)row.get("question_id"));
//			q.setQuestion_order((Integer)row.get("question_order"));
//			q.setQuestion_text((String)row.get("question_text"));
//			q.setQuestion_type((Integer)row.get("question_type"));
//			q.setSurvey_id((Integer)row.get("survey_id"));
//			questions.add(q);
//		}
		//questions.add(question);
		return questions;
	}
}
