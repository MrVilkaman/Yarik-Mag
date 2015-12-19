package dnr.donnu.diagnosiscar;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.io.IOException;
import java.util.List;

import dnr.donnu.diagnosiscar.model.db.DbModule;
import dnr.donnu.diagnosiscar.model.db.DbOpenHelper;
import dnr.donnu.diagnosiscar.model.db.tables.CategoryTable;
import dnr.donnu.diagnosiscar.model.entity.Category;

public class App extends Application{

	private StorIOSQLite storIOSQLite;

	@NonNull
	public static App get(Context context){
		return (App)context.getApplicationContext();
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	@NonNull
	public StorIOSQLite getStorIOSQLite() {
		if (storIOSQLite == null) {
			synchronized (App.class) {
				if (storIOSQLite == null) {
					DbOpenHelper sqLiteOpenHelper = new DbOpenHelper(getApplicationContext());
					sqLiteOpenHelper.createDataBase();
					storIOSQLite = new DbModule().provideStorIOSQLite(sqLiteOpenHelper);
				}
			}
		}
		return storIOSQLite;
	}
}
