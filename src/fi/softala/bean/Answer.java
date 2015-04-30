/** @authors Jukka, Pasi, Kytis, Olli
*/
package fi.softala.bean;

public class Answer {
	private int answerId;
	private int questionId;
	private String answerText;
	//private String aChoiceText;
	private String questionText;
	
	
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Answer(int answerId, String answerText, int questionId, String aChoiceText, String questionText) {
		super();
		this.answerId = answerId;
		this.answerText =  answerText;
		this.questionId=questionId;
		//this.aChoiceText = aChoiceText;
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
//	public String getaChoiceText() {
//		return aChoiceText;
//	}
//	public void setaChoiceText(String aChoiceText) {
//		this.aChoiceText = aChoiceText;
//	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

}