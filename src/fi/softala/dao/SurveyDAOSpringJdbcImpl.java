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
		
		final String sql="INSERT INTO Survey(survey_name, email) values (?, ?)";
		final String surveyName=newSurvey.getSurveyName();
		final String email=newSurvey.getEmail();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "survey_id" }); //Luo uudelle surveylle oman id:n
				ps.setString(1, surveyName);
				ps.setString(2, email);
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
		//Object[] param = new Object[] { i };
		RowMapper<Survey> mapper = new SurveyRowMapper();
		
		try {
			List<Survey> surveys = jdbcTemplate.query(sql, mapper);
			return surveys;
		} catch (DataAccessException e) {
			throw e;
		} catch (RuntimeException e) {
			throw new DaoConnectionException("virhe", e);
		}
	}
	
	public int findLastId(){
		int id=0;
		String sql = "SELECT survey_id FROM Survey WHERE survey_id=(SELECT max(survey_id) FROM Survey);";
		
		try {
			id = jdbcTemplate.queryForObject(sql, Integer.class);
			return id;
		} catch (DataAccessException e) {
			throw e;
		} catch (RuntimeException e) {
			throw new DaoConnectionException("virhe", e);
		}
	}
}
