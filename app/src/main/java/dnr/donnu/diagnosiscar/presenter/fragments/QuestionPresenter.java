package dnr.donnu.diagnosiscar.presenter.fragments;


import android.os.Bundle;

import java.io.Serializable;

import dnr.donnu.diagnosiscar.view.fragments.QuestionView;

public abstract class QuestionPresenter extends BasePresenter<QuestionView> {

	public abstract void clickYes();

	public abstract void clickNo();

	public abstract void showQuestion(int questionItemId);

	public abstract void initScreen(Bundle savedInstanceState, int firstId);
}
