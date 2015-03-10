/**
 * 
 */
package fi.softala.dao;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import fi.softala.bean.Survey;
import fi.softala.bean.Question;


/**
 * @author Pasi Lehmusvuori
 * @param <Survey>
 *
 */

public abstract class SurveyJdbcDao implements SurveyDAO {
  private JdbcTemplate jdbcTemplate;
   private String sql;
   
 
   public void setDataSource(DataSource dataSource) {
       this.jdbcTemplate = new JdbcTemplate(dataSource);
   }
   
   
   /**
    DB fields
    survey_id
 *  survey_name
 *  owner_id
 *  email 
    */
   public void insertSurvey(final Survey survey){
	   sql = "insert into Survey (survey_name) values(?)";

	   KeyHolder keyHolder = new GeneratedKeyHolder();
	   this.jdbcTemplate.update(
	       new PreparedStatementCreator() {
	           public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
	               PreparedStatement ps = connection.prepareStatement(sql, new String[] {"survey_id"});
	               ps.setString(1,survey.getName());
	               return ps;
	           }
	       },
	       keyHolder);
	   	   
	   survey.setId(keyHolder.getKey().intValue());
   }
   
   
   /*
		id = question_id;
		seqNum - question_order; -> sequence number!
		question - question_text; -> question itself
		type - question_type; -> type of the question
    */

public void insertQuestions(final int survey_id,final List<Question> questions) {
      String sql = "INSERT INTO Question"
				+ "("
				+ "survey_id,"
				+ "question_order"
				+ "question_type"
				+ "question_text"
				+ ")"
				+ " VALUES("
				+ "?,"
				+ "?,"
				+ "?,"
				+ "?"
				+ ")";
      
      this.jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter(){
    		public void setValues(PreparedStatement ps, int i) throws SQLException {
    			Question q = questions.get(i);
    					ps.setInt(1,survey_id);
    		   			ps.setInt(2,q.getSeqNum());
    		   			ps.setInt(3,q.getType());
    		   			ps.setString(4,q.getQuestion());
    	   	}

			@Override
			public int getBatchSize() {
				return questions.size();
			}
      });
   }
   

@SuppressWarnings("unchecked")
@Override
   public List<Question> getById(int survey_id) {
       return (List<Question>) jdbcTemplate.queryForObject(
               "select * from question where survey_id = ?",
               new Object[]{survey_id}, new QuestionMapper());
   }
   
   
   //Inner class for Question row mapper
   private static final class QuestionMapper implements RowMapper<Question> {
       @Override
       public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
       	return new Question(
		rs.getInt("question_id"),
		rs.getInt("question_order"),
		rs.getInt("question_type"),
		rs.getString("question_text")
		);
       }
   }
   
 //Inner class for Survey row mapper
   @SuppressWarnings("unused")
private static final class SurveyMapper implements RowMapper<Survey> {
       @Override
       public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
       	return new Survey(
		rs.getInt("survey_id"),
		rs.getInt("owner_id"), // Not implemented yet
		rs.getString("survey_name"),
		null
		);
       }
   }
}