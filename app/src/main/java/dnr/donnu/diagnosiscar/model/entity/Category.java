package dnr.donnu.diagnosiscar.model.entity;


import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteColumn;
import com.pushtorefresh.storio.sqlite.annotations.StorIOSQLiteType;

import dnr.donnu.diagnosiscar.model.db.tables.CategoryTable;

@StorIOSQLiteType(table = CategoryTable.TABLE)
public class Category {

	@StorIOSQLiteColumn(name = CategoryTable.TITLE)
	String title;

	@StorIOSQLiteColumn(name = CategoryTable.FIRST_ID, key = true)
	int firstQuestionId;

	public String getTitle() {
		return title;
	}

	public int getFirstQuestionId() {
		return firstQuestionId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Category{" +
				"title='" + title + '\'' +
				", firstQuestionId=" + firstQuestionId +
				'}';
	}
}
