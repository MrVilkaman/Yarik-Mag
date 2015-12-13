package dnr.donnu.diagnosiscar.model.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

public class DbOpenHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "CarDb";
	public static final int DB_VERSION = 1;

	public DbOpenHelper(@NonNull Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(@NonNull SQLiteDatabase db) {

	}

	@Override
	public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
		// no impl
	}
}
