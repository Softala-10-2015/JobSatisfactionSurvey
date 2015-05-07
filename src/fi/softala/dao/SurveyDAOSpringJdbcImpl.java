/**
 * @author Aleksi Tilli, Pasi, Jukka, Olli, Samuli, Topi, Juha Palmu, Harri, Erik, Petri, Pipsa, Mikot, Markus
 *
 */

package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Answer;
import fi.softala.bean.Question;
import fi.softala.bean.Survey;

@Repository
public class SurveyDAOSpringJdbcImpl implements SurveyDao{
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	public void addSurvey(Survey newSurvey) {
		
		final String sql="INSERT INTO Survey(survey_name) values (?)";
		final String surveyName=newSurvey.getSurveyName();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "survey_id" }); //Luo uudelle surveylle oman id:n
				ps.setString(1, surveyName);
				return ps;
			}
		}, idHolder);
	
		newSurvey.setSurveyId(idHolder.getKey().intValue());
	}
	
	
	public Survey findSurvey(int i) {
		//RAW metodi, siistimistä vailla
		
		String sql = "SELECT *  FROM Survey WHERE survey_id = ?";
		Object[] param = new Object[] { i };
		RowMapper<Survey> mapper = new SurveyRowMapper();
		try {
			Survey survey = jdbcTemplate.queryForObject(sql,param, mapper);
			return survey;
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new NotFoundException(e);
		}
	
	}
	
	public List<Survey> findSurveys() throws DataAccessException, RuntimeException {
		//kaikki kyselyt, vois varmaan siisitiä
		
		String sql = "SELECT * FROM Survey;";
		
		RowMapper<Survey> mapper = new SurveyRowMapper();
		
		try {
			List<Survey> surveys = jdbcTemplate.query(sql, mapper);
			return surveys;
		} catch (DataAccessException e) {
			throw e;
		}
	}
	
	//Testataan, onko muokkaukseen valitussa kyselyssä vastauksia
	public boolean ifHasAnswers(int surveyId) {
		String sql = "SELECT a.answer_id, a.question_id, a.answer_text, q.question_text FROM Answer a JOIN Question q ON a.question_id=q.question_id JOIN Survey s ON q.survey_id=s.survey_id  WHERE s.survey_id=?";
		boolean hasAnswers=true;
		Object[] param = new Object[] { surveyId};
		RowMapper<Answer> mapper = new AnswerTextRowMapper();
		try{
			List<Answer> answers = jdbcTemplate.query(sql, param, mapper);
			System.out.println(answers);
			if(answers.isEmpty()) {
				hasAnswers=false;
			}
		} catch(DataAccessException e) {
			throw e;
		}
		
		return hasAnswers;
	}
	
	public int findLastId(){
		int id=0;
		String sql = "SELECT survey_id FROM Survey WHERE survey_id=(SELECT max(survey_id) FROM Survey);";
		
		try {
			id = jdbcTemplate.queryForObject(sql, Integer.class);
			return id;
		} catch (DataAccessException e) {
			throw e;
		}
	}
}
