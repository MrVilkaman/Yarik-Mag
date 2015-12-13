package dnr.donnu.diagnosiscar.presenter.fragments;


import dnr.donnu.diagnosiscar.model.entity.Question;

public class CategoryPresenterImpl extends CategoryPresenter {


	@Override
	public void clickOnItem(int user) {
		getView().openAnswer(new Question());
	}
}
