package dnr.donnu.diagnosiscar.presenter.fragments;


public class CategoryPresenterImpl extends CategoryPresenter {


	@Override
	public void clickOnItem(int user) {
			getView().openAnswer(user);
	}
}
