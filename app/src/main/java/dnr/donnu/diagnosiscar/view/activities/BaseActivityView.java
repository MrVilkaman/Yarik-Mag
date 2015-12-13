package dnr.donnu.diagnosiscar.view.activities;


import dnr.donnu.diagnosiscar.view.toolbar.Toolbar;

public interface BaseActivityView {

	void showProgress();
	void hideProgress();
	void clearProgress();

	void back();

	void hideKeyboard();

	Toolbar getToolbar();
}
