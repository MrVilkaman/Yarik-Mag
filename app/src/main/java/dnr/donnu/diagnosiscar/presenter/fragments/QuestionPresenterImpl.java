package dnr.donnu.diagnosiscar.presenter.fragments;

import java.io.Serializable;

/**
 * Created by Zahar on 13.12.2015.
 */
public class QuestionPresenterImpl extends QuestionPresenter {

	@Override
	protected void onViewAttached() {
		super.onViewAttached();
		getView().showQuestion("Привет)");
	}

	@Override
	public void clickYes() {

	}

	@Override
	public void clickNo() {

	}

	@Override
	public void setFirstQuestion(Serializable questionItem) {

	}
}
