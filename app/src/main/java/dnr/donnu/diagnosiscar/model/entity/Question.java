package dnr.donnu.diagnosiscar.model.entity;


import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import java.io.Serializable;

import dnr.donnu.diagnosiscar.model.db.tables.QuestionTable;

@StorIOSQLiteType(table = QuestionTable.TABLE)
public class Question implements Serializable {

	@StorIOSQLiteColumn(name = QuestionTable.ID, key = true)
	int id;
	@StorIOSQLiteColumn(name = QuestionTable.TITLE)
	String text;
	@StorIOSQLiteColumn(name = QuestionTable.YES_ID)
	int nextYesQuestionId;
	@StorIOSQLiteColumn(name = QuestionTable.NO_ID)
	int nextNoQuestionId;
	@StorIOSQLiteColumn(name = QuestionTable.IS_YES_ANSWER)
	boolean isYesAnswer;
	@StorIOSQLiteColumn(name = QuestionTable.IS_NO_ANSWER)
	boolean isNoAnswer;

	public String getText() {
		return text;
	}

	public int getNextYesQuestionId() {
		return nextYesQuestionId;
	}

	public int getNextNoQuestionId() {
		return nextNoQuestionId;
	}

	public boolean isYesAnswer() {
		return isYesAnswer;
	}

	public boolean isNoAnswer() {
		return isNoAnswer;
	}

	@Override
	public String toString() {
		return  "id = " + id +
				", question = " + text +
				", nextYesQuestionId = " + nextYesQuestionId +
				", nextNoQuestionId = " + nextNoQuestionId +
				", isYesAnswer = " + isYesAnswer +
				", isNoAnswer = " + isNoAnswer;
	}

	public int getId() {
		return id;
	}
}
