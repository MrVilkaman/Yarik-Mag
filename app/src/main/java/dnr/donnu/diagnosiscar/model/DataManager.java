package dnr.donnu.diagnosiscar.model;

import java.util.List;

import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.model.entity.Question;
import rx.Observable;

public interface DataManager {

	Observable<List<Category>> getCategory();

	Observable<Question> getQuestion(int questionId);
}
