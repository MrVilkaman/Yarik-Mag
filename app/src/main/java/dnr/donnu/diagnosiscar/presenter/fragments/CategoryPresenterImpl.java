package dnr.donnu.diagnosiscar.presenter.fragments;


import com.pushtorefresh.storio.sqlite.StorIOSQLite;

import dnr.donnu.diagnosiscar.App;
import dnr.donnu.diagnosiscar.model.entity.Question;

public class CategoryPresenterImpl extends CategoryPresenter {


	public CategoryPresenterImpl() {
	}

	@Override
	public void clickOnItem(int user) {
		getView().openAnswer(new Question());
	}

	@Override
	public void loadCategories() {
		getDM().getCategory()
				.subscribe((categories -> getView().showCategories(categories)));
	}
}
