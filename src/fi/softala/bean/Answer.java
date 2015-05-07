/** @authors Jukka, Pasi, Kytis, Olli, Harri, Pipsa
*/
package fi.softala.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Answer {
	private int answerId;
	private int questionId;
	
	@NotNull
	@Size(min = 2, max = 3000)
	private String answerText;

	private String questionText;
	
	public Answer() {
		super();
	}
	
	public Answer(int answerId, String answerText, int questionId, String aChoiceText, String questionText) {
		super();
		this.answerId = answerId;
		this.answerText =  answerText;
		this.questionId=questionId;
		this.questionText=questionText;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswerText() {
		return answerText;
	}
	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

}