package dnr.donnu.diagnosiscar.presenter.fragments;


import java.io.Serializable;

import dnr.donnu.diagnosiscar.view.fragments.QuestionView;

public abstract class QuestionPresenter extends BasePresenter<QuestionView> {

	public abstract void clickYes();

	public abstract void clickNo();

	public abstract void setFirstQuestion(Serializable questionItem);
}
