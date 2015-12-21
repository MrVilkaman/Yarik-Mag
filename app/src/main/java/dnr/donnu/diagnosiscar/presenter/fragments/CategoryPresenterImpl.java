package dnr.donnu.diagnosiscar.presenter.fragments;


import dnr.donnu.diagnosiscar.model.entity.Category;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

public class CategoryPresenterImpl extends CategoryPresenter {


	public CategoryPresenterImpl() {
	}

	@Override
	public void clickOnItem(Category category) {
		Observable.combineLatest(
				getDM().getQuestion(category.getFirstQuestionId()),
				Observable.just(category),
				(question, cat) -> {
					getView().openQuestionScreen(question,cat);
					return true;
				})
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe();
	}

	@Override
	public void loadCategories() {
		getDM().getCategory()
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(categories -> getView().showCategories(categories));
	}
}
