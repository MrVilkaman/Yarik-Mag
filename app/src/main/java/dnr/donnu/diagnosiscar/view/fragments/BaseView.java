package dnr.donnu.diagnosiscar.view.fragments;


import android.content.Context;

import dnr.donnu.diagnosiscar.presenter.fragments.BasePresenter;


public interface BaseView {
	Context getContext();

	BasePresenter getPresenter();

	void showProgress();
	void hideProgress();

	void showError(Throwable throwable);

	void showMessage(int testId);
}
