package fi.softala.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fi.softala.bean.Answer;

/** @author Jukka, Pasi, Kytis, Olli, Topi, Pipsa
*/

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
	
	public void saveAnswer(Answer answer) {		//Tallentaa vastauksen tietokantaan
		final String sql = "insert into Answer(question_id, answer_text) values (?,?)"; //SQL-lause tallennusta varten
		
		if(answer.getQuestionId() != 0 && answer.getAnswerText() != null){
			final int questionId = answer.getQuestionId(); //annetaan paikallisille muuttujille arvot tietokantataulusta
			final String answerText=answer.getAnswerText();	
			KeyHolder idHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(sql,
							new String[] { "answer_id" });
					ps.setInt(1, questionId); 		//Ensimmäinen parametri SQL-lauseeseen
					ps.setString(2, answerText);	//Toinen parametri SQL-lauseeseen
					return ps;
				}
			}, idHolder);
			answer.setAnswerId(idHolder.getKey().intValue());
		}
	}
	
	public List<Answer> getAnswersForSurvey(int surveyId) {		//Hakee yhden kyselyn kaikki kysymykset ja vastaukset
		String sql = "SELECT Answer.answer_id, Answer.question_id, Answer.answer_text, "
				+ "Question.question_text, Question.question_order "
				+ "FROM Answer "
				+ "LEFT JOIN Question ON Answer.question_id=Question.question_id "
				+ "LEFT JOIN Survey ON Question.survey_id=Survey.survey_id "
				+ "WHERE Survey.survey_id=? "
				+ "ORDER BY Question.question_order";
		
		
		Object[] params = new Object[] { surveyId };
		
		RowMapper<Answer> mapper = new AnswerRowMapper();
		
		List<Answer> answers= jdbcTemplate.query(sql, params, mapper);	//Tehdään vastauksista lista

		return answers;
	}
}
