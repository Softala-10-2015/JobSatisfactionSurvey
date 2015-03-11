/**
* @author Pasi, Samuli
*/

package fi.softala.bean;

public class Question{
	int survey_id;
	int question_id; // id
	int question_order; // question sequence number 
	/* int total; // total option ? */
	String question_text; // question
	/* List options; // question options - answer choices- value pair */
	int question_type;

	public Question() {
	}

	public Question(int survey_id, int question_id,
			int question_order, String question_text, int question_type) {
		this.survey_id = survey_id;
		this.question_id = question_id;
		this.question_order = question_order;
		this.question_text = question_text;
		this.question_type = question_type;
	}

	public int getSurvey_id() {
		return survey_id;
	}

	public void setSurvey_id(int survey_id) {
		this.survey_id = survey_id;
	}

	public int getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(int question_id) {
		this.question_id = question_id;
	}

	public int getQuestion_order() {
		return question_order;
	}

	public void setQuestion_order(int question_order) {
		this.question_order = question_order;
	}

	public String getQuestion_text() {
		return question_text;
	}

	public void setQuestion_text(String question_text) {
		this.question_text = question_text;
	}

	public int getQuestion_type() {
		return question_type;
	}

	public void setQuestion_type(int question_type) {
		this.question_type = question_type;
	}	
}

