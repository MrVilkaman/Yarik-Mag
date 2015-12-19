package dnr.donnu.diagnosiscar.model.db;


import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio.sqlite.SQLiteTypeMapping;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.impl.DefaultStorIOSQLite;

import dnr.donnu.diagnosiscar.model.entity.Answer;
import dnr.donnu.diagnosiscar.model.entity.AnswerStorIOSQLiteDeleteResolver;
import dnr.donnu.diagnosiscar.model.entity.AnswerStorIOSQLiteGetResolver;
import dnr.donnu.diagnosiscar.model.entity.AnswerStorIOSQLitePutResolver;
import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLiteDeleteResolver;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLiteGetResolver;
import dnr.donnu.diagnosiscar.model.entity.CategoryStorIOSQLitePutResolver;
import dnr.donnu.diagnosiscar.model.entity.Question;
import dnr.donnu.diagnosiscar.model.entity.QuestionStorIOSQLiteDeleteResolver;
import dnr.donnu.diagnosiscar.model.entity.QuestionStorIOSQLiteGetResolver;
import dnr.donnu.diagnosiscar.model.entity.QuestionStorIOSQLitePutResolver;

public class DbModule {

	public StorIOSQLite provideStorIOSQLite(@NonNull SQLiteOpenHelper sqLiteOpenHelper) {
		return DefaultStorIOSQLite.builder()
				.sqliteOpenHelper(sqLiteOpenHelper)
				.addTypeMapping(Category.class, SQLiteTypeMapping.<Category>builder()
						.putResolver(new CategoryStorIOSQLitePutResolver())
						.getResolver(new CategoryStorIOSQLiteGetResolver())
						.deleteResolver(new CategoryStorIOSQLiteDeleteResolver())
						.build())
				.addTypeMapping(Question.class, SQLiteTypeMapping.<Question>builder()
						.putResolver(new QuestionStorIOSQLitePutResolver())
						.getResolver(new QuestionStorIOSQLiteGetResolver())
						.deleteResolver(new QuestionStorIOSQLiteDeleteResolver())
						.build())
				.addTypeMapping(Answer.class, SQLiteTypeMapping.<Answer>builder()
						.putResolver(new AnswerStorIOSQLitePutResolver())
						.getResolver(new AnswerStorIOSQLiteGetResolver())
						.deleteResolver(new AnswerStorIOSQLiteDeleteResolver())
						.build())
				.build();
	}
}
