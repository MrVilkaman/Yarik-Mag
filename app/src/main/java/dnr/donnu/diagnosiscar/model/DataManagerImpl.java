package dnr.donnu.diagnosiscar.model;


import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.pushtorefresh.storio.sqlite.StorIOSQLite;
import com.pushtorefresh.storio.sqlite.queries.Query;

import java.util.List;

import dnr.donnu.diagnosiscar.model.db.tables.AnswerTable;
import dnr.donnu.diagnosiscar.model.db.tables.CategoryTable;
import dnr.donnu.diagnosiscar.model.db.tables.QuestionTable;
import dnr.donnu.diagnosiscar.model.entity.Answer;
import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.model.entity.Question;
import rx.Observable;

public class DataManagerImpl implements DataManager {

	private final StorIOSQLite storIOSQLite;

	public DataManagerImpl(StorIOSQLite storIOSQLite){
		this.storIOSQLite = storIOSQLite;
	}


	//// TODO: 20.12.2015 replace with dbhelper
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

	@Override
	public Observable<Question> getQuestion(int questionId) {
		return storIOSQLite
				.get()
				.listOfObjects(Question.class)
				.withQuery(Query.builder()
						.table(QuestionTable.TABLE)
						.where(QuestionTable.ID +" = ?")
						.whereArgs(questionId)
						.build())
				.prepare()
				.createObservable()
				.first()
				.filter(questions -> !questions.isEmpty())
				.flatMap(questions -> Observable.just(questions.get(0)));
	}

	@Override
	public Observable<Answer> getAnswer(int id) {
		return storIOSQLite
				.get()
				.listOfObjects(Answer.class)
				.withQuery(Query.builder()
						.table(AnswerTable.TABLE)
						.where(AnswerTable.ID +" = ?")
						.whereArgs(id)
						.build())
				.prepare()
				.createObservable()
				.first()
				.filter(questions -> !questions.isEmpty())
				.flatMap(questions -> Observable.just(questions.get(0)));
	}
}
