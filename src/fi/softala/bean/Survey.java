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
	
	//JAVA ATRIBUUTTEJA
	boolean isComplete;
	int nextFree;
	List<Question> questions;
	List<Answer> answers;

	public Survey() {
		super();
		   questions = new ArrayList<Question>();
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

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getNextFree() {
		return nextFree;
	}

	public void setNextFree(int nextFree) {
		this.nextFree = nextFree;
	}
	
	public void addQuestion(Question q){
		questions.add(q);
	}
	
	public void removeQuestion(Question q){
		questions.remove(q);
	}
	
	public void setQuestions(List<Question> q){
		this.questions = q;
	}

	public List<Question> getQuestions() {
		return questions;
	}
	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Survey [surveyId=" + surveyId + ", ownerId=" + ownerId
				+ ", surveyName=" + surveyName
				+ ", isComplete=" + isComplete + ", nextFree=" + nextFree
				+ ", questions=" + questions + ", answers=" + answers + "]";
	}
}
