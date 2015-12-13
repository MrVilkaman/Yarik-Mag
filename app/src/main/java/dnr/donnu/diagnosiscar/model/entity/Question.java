package dnr.donnu.diagnosiscar.model.entity;


import java.io.Serializable;

public class Question implements Serializable {

	int id;
	System question;
	int nextYesQuestionId;
	int nextNoQuestionId;
	boolean hasAnswer;

	public System getQuestion() {
		return question;
	}

	public int getNextYesQuestionId() {
		return nextYesQuestionId;
	}

	public int getNextNoQuestionId() {
		return nextNoQuestionId;
	}

	public boolean isHasAnswer() {
		return hasAnswer;
	}
}
