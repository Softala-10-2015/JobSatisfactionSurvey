/**
* @author Pasi, Samuli, Jukka
*/
package fi.softala.bean;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Survey {
	
	//DAO ATRIBUUTIT
	int surveyId; 
	int ownerId;
	
	@Size(min=1, max=50, message="Kyselyn nimessä tulee olla 1-50 merkkiä")
	@Pattern(regexp = "[a-zöäåA-ZÖÄÅ0-9 !\"#¤%&/()=?`´^*¨\'~<>|{}\\+-_.:,;£$€\\[\\]]+", message="Kyselyn nimessä saa olla kirjaimia, numeroita ja vain yleisesti käytettyjä erikoismerkkejä")
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
