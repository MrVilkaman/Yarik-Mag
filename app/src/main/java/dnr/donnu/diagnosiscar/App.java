package dnr.donnu.diagnosiscar;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import dnr.donnu.diagnosiscar.model.db.DbModule;
import dnr.donnu.diagnosiscar.model.db.DbOpenHelper;

public class App extends Application{

	private StorIOSQLite storIOSQLite;

	@NonNull
	public static App get(Context context){
		return (App)context.getApplicationContext();
	}

	@NonNull
	public StorIOSQLite getStorIOSQLite() {
		if (storIOSQLite == null) {
			synchronized (App.class) {
				if (storIOSQLite == null) {
					storIOSQLite = new DbModule().provideStorIOSQLite(new DbOpenHelper(getApplicationContext()));
				}
			}
		}
		return storIOSQLite;
	}
}
