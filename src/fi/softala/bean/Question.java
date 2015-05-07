/**
* @author Pasi, Samuli
*/

package fi.softala.bean;

import java.util.ArrayList;
import java.util.List;

//standardeja jsr303-annotaatioita
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;

public class Question{
	
	int surveyId;
	int questionId; // id
	@NotNull
	int questionOrder; // question sequence number 
	@NotNull
	@Size (min=1, max=100)
	String questionText; // question
	
	int questionType;
	List<AChoice> choices = new ArrayList<AChoice>();

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

	public List<AChoice> getChoices() {
		return choices;
	}

	public void setChoices(List<AChoice> choices) {
		this.choices = choices;
	}

	@Override
	public String toString() {
		return "Question [surveyId=" + surveyId + ", questionId=" + questionId
				+ ", questionOrder=" + questionOrder + ", questionText="
				+ questionText + ", questionType=" + questionType
				+ ", choices=" + choices + "]";
	}
	
}
