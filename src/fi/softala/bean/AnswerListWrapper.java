package fi.softala.bean;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Aleksi T
 *
 */
public class AnswerListWrapper {
	@Valid
	private List<Answer> answerList;

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}
	
	public void add(Answer answer) {
		this.answerList.add(answer);
	}
	
	
}