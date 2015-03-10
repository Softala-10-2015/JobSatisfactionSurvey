/**
* @author Pasi, Samuli, Jukka
*/
package fi.softala.bean;
import java.util.ArrayList;
import java.util.List;

public class Survey {
	int survey_id;
	int owner_id;
	String survey_name;
	String email;
	boolean isComplete;
	int nextFree;
	List questions;
	
	@SuppressWarnings("rawtypes")
	public Survey() {
		super();
		   questions = new ArrayList();
	}

	public int getSurvey_id() {
		return survey_id;
	}

	public int getOwner_id() {
		return owner_id;
	}

	public void setOwner_id(int owner_id) {
		this.owner_id = owner_id;
	}

	public String getSurvey_name() {
		return survey_name;
	}

	public void setSurvey_name(String survey_name) {
		this.survey_name = survey_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
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
	
}
