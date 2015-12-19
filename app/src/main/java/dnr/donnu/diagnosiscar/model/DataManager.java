package dnr.donnu.diagnosiscar.model;

import java.util.List;

import dnr.donnu.diagnosiscar.model.entity.Category;
import rx.Observable;

public interface DataManager {

	Observable<List<Category>> getCategory();
}
