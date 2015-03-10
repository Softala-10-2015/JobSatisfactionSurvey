package fi.softala.bean;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Pasi Lehmusvuori, Samuli Kytömäki
 * 
 * Corresponding db fields
 * 	survey_id
 *  survey_name
 *  owner_id
 *  email ?
 *  
 */
public class Survey{
	int id;
	String name;
	// owner id
	// publish url
	// publishDate
	// expireDate
	
	boolean isComplete; // is the questionnaire ready to be published
	int totalQuestions;
	// int nextFree;
	List<Question> questions;
	
	public Survey() {
		questions = new ArrayList<Question>();
	}

	public Survey(int id, String name) {
		this.id = id;
		this.name = name;
		questions = new ArrayList<Question>();
	}
	
	public Survey(int id, int owner_id, String name, List<Question> questions) {
		this.id = id;
		this.name = name;
		this.questions = questions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isComplete() {
		return isComplete;
	}

	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}

	public int getTotalQuestions() {
		return totalQuestions;
	}

	public void setTotalQuestions(int totalQuestions) {
		this.totalQuestions = totalQuestions;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(Question q){
		questions.add(q);
	}
	
	public void removeQuestion(int id){
		for(java.util.Iterator<Question> it = questions.iterator();it.hasNext();){
			Question item = it.next();
			if(item.getId() == id){
				it.remove();
				break;
			}
		}
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", name=" + name + ", isComplete="
				+ isComplete + ", totalQuestions=" + totalQuestions
				+ ", questions=" + questions + "]";
	}
}