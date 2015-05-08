/**
* @author Jukka, Samuli, pasi, Harri
*/

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
	
	public void saveQuestion(Question question) {	//Tallennetaan kysymys tietokantaan
		final String sql = "insert into Question(survey_id, question_type, question_text, question_order) values (?,?,?,?)"; //Kysymykseen liittyv�t attribuutit asianmukaiseen tietokantatauluun
		final int surveyId = question.getSurveyId();	//Annetaan paikalliselle surveyId-muuttujalle question-taulun survey_id-kentän arvo
		final int questionType=question.getQuestionType();	//Annetaan paikalliselle questionType-muuttujalle question-taulun question_type-kentän arvo
		final String questionText=question.getQuestionText();	//Annetaan paikalliselle questionText-muuttujalle question-taulun question_text-kentän arvo
		final int questionOrder=question.getQuestionOrder();	////Annetaan paikalliselle questionOrder-muuttujalle question-taulun question_order-kentän arvo
		
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
		question.setQuestionId(idHolder.getKey().intValue());
	}
	
	public Question getOneQuestion(int questionId) { //Metodi, jolla haetaan yksi kysymys kerrallaan tietokantataulusta. Käytetään kysymysten järjestyksen muokkaamiseen
		String sql = "select question_id, survey_id, question_type, question_text, question_order from Question where question_id=?";
		Object[] parameters = new Object[] { questionId };
		RowMapper<Question> mapper = new QuestionRowMapper();
		Question wanted = new Question();
		try {
			wanted=jdbcTemplate.queryForObject(sql, parameters, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			throw new NotFoundException(e);
		}
		return wanted;
	}
	
	//Yksittäisen kysymyksen muokkaus
	public void editQuestion(Question question) {
		final String sql = "update Question set question_text=?, question_order=?, question_type=? where question_id=?";
		final String text = question.getQuestionText();		//annetaan paikallisille muuttujille arvot tietokantataulusta
		final int order = question.getQuestionOrder();
		final int type = question.getQuestionType();
		final int id = question.getQuestionId();
		KeyHolder idHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(
					Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql,
						new String[] { "question_id" }); //Luo uudelle kysymykselle oman id:n
				ps.setString(1, text); //tallennetaan kysymykseen liittyv�t attribuutit
				ps.setInt(2, order);
				ps.setInt(3, type);
				ps.setInt(4, id);
				System.out.println(ps);
				return ps;
			}
		}, idHolder);		
	}
	
	/* (non-Javadoc) Hakee kysymyksiä kyselyn id:n perusteella
	 * @see fi.softala.dao.QuestionDAO#getQuestionsForSurvey(int)
	 */
	public List<Question> getQuestionsForSurvey(int surveyId) {		//hakee kaikki kysymykset yhteen kyselyyn
		String sql = "SELECT question_id, survey_id, question_type, "
				+ "question_text, question_order "
				+ "FROM Question "
				+ "WHERE survey_id = ? "
				+ "ORDER BY question_order";
		
		Object[] params = new Object[] { surveyId };
		System.out.println("QuestionDAO: " + params[0]);
		RowMapper<Question> mapper = new QuestionRowMapper();
		
		List<Question> questions= jdbcTemplate.query(sql, params, mapper);	//tekee listan kysymyksistä

		return questions;
	}
	
	public void deleteQuestion(int questionId) {	//poistaa kysymyksen
		String sql = "DELETE FROM Question WHERE question_id = ?";
		Object[] params = new Object[] { questionId };
		System.out.println("QuestionDAO: DELETE " + params[0]);
		
		this.jdbcTemplate.update(sql, params);
	}
}
