package dnr.donnu.diagnosiscar.presenter.fragments;


import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenterImpl extends CategoryPresenter {


	public CategoryPresenterImpl() {
	}

	@Override
	public void clickOnItem(int questionId) {
		getDM().getQuestion(questionId)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(question -> getView().openQuestionScreen(question));
	}

	@Override
	public void loadCategories() {
		getDM().getCategory()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(categories -> getView().showCategories(categories));
	}
}
