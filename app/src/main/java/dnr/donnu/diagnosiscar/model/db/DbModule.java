package dnr.donnu.diagnosiscar.model.db;


import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLiteDeleteResolver;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLiteGetResolver;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLitePutResolver;

public class DbModule {

	public StorIOSQLite provideStorIOSQLite(@NonNull SQLiteOpenHelper sqLiteOpenHelper) {
		return DefaultStorIOSQLite.builder()
				.sqliteOpenHelper(sqLiteOpenHelper)
				.addTypeMapping(Category.class, SQLiteTypeMapping.<Category>builder()
						.putResolver(new CategoryStorIOSQLitePutResolver())
						.getResolver(new CategoryStorIOSQLiteGetResolver())
						.deleteResolver(new CategoryStorIOSQLiteDeleteResolver())
						.build())
				.build();
	}
}
