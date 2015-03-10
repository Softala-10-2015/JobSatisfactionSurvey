package fi.softala.bean;

/**
 * 
 * @author Pasi Lehmusvuori, Samuli Kytömäki
 *
 * Corresponding db fields
 * 	question_id
	question_order - question sequence number 
	question_type  - question type 1=open, 2= radiobutton list
	question_text  - question itself
 */

public class Question {
	int id; // id
	int seqNum; // question sequence number 
	int type;  // Question type 1=open, 2=radiobutton list
	String question; // question
	
	/* int total; // total options ? */
	
	public Question() {
		this.id = 0;
		this.seqNum = 0;
		this.type = 0;
		this.question = "";
	}

	public Question(int id, int sequenceNum, int type, String question) {
		super();
		this.id = id;
		this.seqNum = sequenceNum;
		this.type = type;
		this.question = question;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeqNum() {
		return seqNum;
	}

	public void setSeqNum(int seqNum) {
		this.seqNum = seqNum;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Question [id=" + id + ", seqNum=" + seqNum + ", type=" + type
				+ ", question=" + question + "]";
	}

}
