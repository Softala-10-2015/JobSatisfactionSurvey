package fi.softala.dao;


public class KyselyDao {

	public void HaeKysely(Jokubean x) {
	
		//BEAN = kyseky bean tulevaisuudessa
		
		String sql = "SELECT *  FROM Survey WHERE survey_id = '?';";
		RowMapper<Bean> mapper = new BeanRowMapper();
		List<Bean> Beans = jdbcTemplate.query(sql, mapper);

	return beans;
}
}
