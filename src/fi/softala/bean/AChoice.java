package fi.softala.bean;

public class AChoice {
	private int aChoiceId;
	private int questionId;
	private String aChoiceText;
	
	public AChoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AChoice(int aChoiceId, String aChoiceText, int questionId) {
		super();
		this.aChoiceId = aChoiceId;
		this.aChoiceText =  aChoiceText;
		this.questionId=questionId;
	}
	public int getaChoiceId() {
		return aChoiceId;
	}
	public void setaChoiceId(int aChoiceId) {
		this.aChoiceId = aChoiceId;
	}
	public String getaChoiceText() {
		return aChoiceText;
	}
	public void setaChoiceText(String aChoiceText) {
		this.aChoiceText = aChoiceText;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

}