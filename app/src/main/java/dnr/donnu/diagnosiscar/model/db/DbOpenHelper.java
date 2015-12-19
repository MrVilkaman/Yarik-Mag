package dnr.donnu.diagnosiscar.model.db;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DbOpenHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "CarDb.db";
	public static final int DB_VERSION = 1;

	private final Context mContext;

	public DbOpenHelper(@NonNull Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		mContext = context;
	}

	@Override
	public void onCreate(@NonNull SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
		// no impl
	}

	public void createDataBase() {
		File dbFile = mContext.getDatabasePath(DB_NAME);

		if (!dbFile.exists()) {
			File psth = mContext.getDatabasePath("stub");
			psth.mkdirs();
			try {
				copyDatabase(dbFile);
			} catch (IOException e) {
				throw new RuntimeException("Error creating source database", e);
			}
		}
	}

	private void copyDatabase(File dbFile) throws IOException {
		InputStream is = mContext.getAssets().open(DB_NAME);
		OutputStream os = new FileOutputStream(dbFile);

		byte[] buffer = new byte[1024];
		while (is.read(buffer) > 0) {
			os.write(buffer);
		}

		os.flush();
		os.close();
		is.close();
	}
}
