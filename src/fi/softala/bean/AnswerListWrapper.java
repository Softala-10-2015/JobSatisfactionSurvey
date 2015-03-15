package fi.softala.bean;

import java.util.List;

/**
 * @author Aleksi T
 *
 */
public class AnswerListWrapper {
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
