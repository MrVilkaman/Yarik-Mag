package dnr.donnu.diagnosiscar.model.entity;

import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import dnr.donnu.diagnosiscar.model.db.tables.AnswerTable;

@StorIOSQLiteType(table = AnswerTable.TABLE)
public class Answer {


	@StorIOSQLiteColumn(name = AnswerTable.ID, key = true)
	int id;
	@StorIOSQLiteColumn(name = AnswerTable.TITLE)
	String text;

	public int getId() {
		return id;
	}

	public String getText() {
		return text;
	}
}
