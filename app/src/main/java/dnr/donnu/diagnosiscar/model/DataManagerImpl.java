package dnr.donnu.diagnosiscar.model;


import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.List;

import dnr.donnu.diagnosiscar.model.db.tables.CategoryTable;
import dnr.donnu.diagnosiscar.model.entity.Category;
import rx.Observable;

public class DataManagerImpl implements DataManager {

	private final StorIOSQLite storIOSQLite;

	public DataManagerImpl(StorIOSQLite storIOSQLite){
		this.storIOSQLite = storIOSQLite;
	}

	@Override
	public Observable<List<Category>> getCategory() {
		return storIOSQLite
				.get()
				.listOfObjects(Category.class)
				.withQuery(Query.builder()
				.table(CategoryTable.TABLE)
				.build())
				.prepare()
				.createObservable()
				.first();
	}
}
