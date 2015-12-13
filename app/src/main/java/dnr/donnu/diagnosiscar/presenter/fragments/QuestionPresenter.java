package dnr.donnu.diagnosiscar.presenter.fragments;


import dnr.donnu.diagnosiscar.view.fragments.QuestionView;

public abstract class QuestionPresenter extends BasePresenter<QuestionView> {

	public abstract void clickYes();

	public abstract void clickNo();
}
