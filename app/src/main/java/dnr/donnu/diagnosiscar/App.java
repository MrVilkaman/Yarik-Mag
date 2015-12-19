package dnr.donnu.diagnosiscar;


import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.io.IOException;
import java.util.List;

import dnr.donnu.diagnosiscar.model.DataManager;
import dnr.donnu.diagnosiscar.model.DataManagerImpl;
import dnr.donnu.diagnosiscar.model.db.DbModule;
import dnr.donnu.diagnosiscar.model.db.DbOpenHelper;
import dnr.donnu.diagnosiscar.model.db.tables.CategoryTable;
import dnr.donnu.diagnosiscar.model.entity.Category;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public class App extends Application{

	private StorIOSQLite storIOSQLite;
	private DataManager gm;

	@NonNull
	public static App get(Context context){
		return (App)context.getApplicationContext();
	}

	@Override
	public void onCreate() {
		super.onCreate();

		RxJavaPlugins.getInstance().registerErrorHandler(new RxJavaErrorHandler() {
			@Override
			public void handleError(Throwable e) {
				Log.w("Error", e);
			}
		});
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

	public DataManager getDM() {
		if (gm == null) {
			synchronized (App.class) {
				if (gm == null) {
					gm = new DataManagerImpl(getStorIOSQLite());
				}
			}
		}
		return gm;
	}
}
