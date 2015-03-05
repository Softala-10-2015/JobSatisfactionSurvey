/**
* @author Pasi, Samuli
*/
package fi.softala.bean;
import java.util.ArrayList;
import java.util.List;

public class Survey {
	int survey_id;
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
