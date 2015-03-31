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
		
		final String sql="INSERT INTO Survey(survey_id, owner_id, survey_name, email) values (?, ?, ?, ?)";
		final int surveyId=newSurvey.getSurvey_id();
		final int ownerId=newSurvey.getOwner_id();
		final String surveyName=newSurvey.getSurvey_name();
		final String email=newSurvey.getEmail();
		
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "survey_id" }); //Luo uudelle surveylle oman id:n
				ps.setInt(1, surveyId); //tallennetaan surveyyn liittyv�t attribuutit
				ps.setInt(2, ownerId);
				ps.setString(3, surveyName);
				ps.setString(4, email);
				return ps;
			}
		}, idHolder);
		newSurvey.setSurvey_id(idHolder.getKey().intValue());
	}
	
	
	public Survey FindSurvey(int i) {
		//RAW metodi, siistimistä vailla
		
		String sql = "SELECT *  FROM Survey WHERE survey_id = '?';";
		Object[] param = new Object[] { i };
		RowMapper<Survey> mapper = new SurveyRowMapper();
		List<Survey> Surveys = jdbcTemplate.query(sql,param, mapper);
		Survey survey = Surveys.get(0);

	return survey;
	}
	
	public List<Survey> FindSurveys(int i) {
		//kaikki kyselyt, vois varmaan siisitiä
		
		String sql = "SELECT * FROM Survey;";
		//Object[] param = new Object[] { i };
		RowMapper<Survey> mapper = new SurveyRowMapper();
		List<Survey> Surveys = jdbcTemplate.query(sql, mapper);
		
		return Surveys;
	}
}
