package dnr.donnu.diagnosiscar.view.fragments;


import java.util.List;

import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.model.entity.Question;

public interface CategoryView extends BaseView{
	void openQuestionScreen(Question question);

	void showCategories(List<Category> categories);
}
