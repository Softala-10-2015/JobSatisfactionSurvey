/**
* @author Pasi, Samuli
*/

package fi.softala.bean;

public class Question{
	int surveyId;
	int questionId; // id
	int questionOrder; // question sequence number 
	/* int total; // total option ? */
	String questionText; // question
	/* List options; // question options - answer choices- value pair */
	int questionType;

	public Question() {
	}

	public Question(int surveyId, int questionId,
			int questionOrder, String questionText, int questionType) {
		this.surveyId = surveyId;
		this.questionId = questionId;
		this.questionOrder = questionOrder;
		this.questionText = questionText;
		this.questionType = questionType;
	}

	public int getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(int surveyId) {
		this.surveyId = surveyId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getQuestionOrder() {
		return questionOrder;
	}

	public void setQuestionOrder(int questionOrder) {
		this.questionOrder = questionOrder;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getQuestionType() {
		return questionType;
	}

	public void setQuestionType(int questionType) {
		this.questionType = questionType;
	}	
}

