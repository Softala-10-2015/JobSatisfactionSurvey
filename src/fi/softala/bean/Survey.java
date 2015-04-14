/**
* @author Pasi, Samuli, Jukka
*/
package fi.softala.bean;
import java.util.ArrayList;
import java.util.List;

public class Survey {
	
	//DAO ATRIBUUTIT
	int surveyId; 
	int ownerId; 
	String surveyName; 
	String email;
	
	//JAVA ATRIBUUTTEJA
	boolean isComplete;
	int nextFree;
	List questions;
	List answers;

	@SuppressWarnings("rawtypes")
	public Survey() {
		super();
		   questions = new ArrayList();
	}

	public int getSurveyId() {
		return surveyId;
	}

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getSurveyName() {
		return surveyName;
	}

	public void setSurveyName(String surveyName) {
		this.surveyName = surveyName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getNextFree() {
		return nextFree;
	}

	public void setNextFree(int nextFree) {
		this.nextFree = nextFree;
	}
	
	@SuppressWarnings("unchecked")
	public void addQuestion(Question q){
		questions.add(q);
	}
	
	public void removeQuestion(Question q){
		questions.remove(q);
	}
	
	public void setQuestions(List<Question> q){
		this.questions = q;
	}

	public List getQuestions() {
		return questions;
	}
	
	public List getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
}
