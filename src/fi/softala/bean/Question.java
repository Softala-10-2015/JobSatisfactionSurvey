package fi.softala.bean;

//standardeja jsr303-annotaatioita
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import javax.validation.constraints.NotNull;

/**
* @author Pasi, Samuli
*/

public class Question{
	
	int surveyId;
	int questionId; // id
	int questionType;
	@NotNull
	int questionOrder; // question sequence number 
	@NotNull
	@Size (min=1, max=100, message="Kyselyn nimessä tulee olla 1-100 merkkiä")
	@Pattern(regexp = "^[a-zöäåA-ZÖÄÅ0-9§½!\"#¤%&/()=?`´^*¨\'~<>|{}\\+-_.:,;£$€\\[\\]]+[ a-zöäåA-ZÖÄÅ0-9§½!\"#¤%&/()=?`´^*¨\'~<>|{}\\+-_.:,;£$€\\[\\]]*$", message="Kysymyksen nimessä saa olla kirjaimia, numeroita ja vain yleisesti käytettyjä erikoismerkkejä, eikä se saa alkaa välilyönnillä")
	String questionText; // question
	
	//int validointia varten
/*	@NotNull
	@Pattern(regexp = "[1-9]*")
	String questionOrderStr;
	
	public String getQuestionOrderStr() {
		return questionOrderStr;
	}*/

	public void setQuestionOrderInteger(String questionOrderStr) {
		this.questionOrder = Integer.parseInt(questionOrderStr);
	}

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

	@Override
	public String toString() {
		return "Question [surveyId=" + surveyId + ", questionId=" + questionId
				+ ", questionOrder=" + questionOrder + ", questionText="
				+ questionText + ", questionType=" + questionType + "]";
	}
	
}
