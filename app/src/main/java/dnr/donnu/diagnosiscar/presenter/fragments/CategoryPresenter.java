package dnr.donnu.diagnosiscar.presenter.fragments;


import dnr.donnu.diagnosiscar.model.entity.Category;
import dnr.donnu.diagnosiscar.view.fragments.CategoryView;

public abstract class CategoryPresenter extends BasePresenter<CategoryView> {
	public abstract void clickOnItem(Category category);

	public abstract void loadCategories();
}
