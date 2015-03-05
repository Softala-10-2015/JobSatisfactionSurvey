package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Survey;

/*
import Surveybean;
*/

public class KyselyDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
//	

	public List<Survey> HaeKysely(Int i) {
	
		//Bean import puuttuu atm
		
		String sql = "SELECT *  FROM Survey WHERE survey_id = '?';";
		Object[] param = new Object[] { i };
		RowMapper<Survey> mapper = new SurveyRowMapper();
		List<Survey> Surveys = jdbcTemplate.query(sql,param, mapper);

	return Surveys;
}
}
