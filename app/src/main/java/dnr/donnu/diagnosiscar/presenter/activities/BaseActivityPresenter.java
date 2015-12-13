package dnr.donnu.diagnosiscar.presenter.activities;


import dnr.donnu.diagnosiscar.view.fragments.BaseFragment;

public interface BaseActivityPresenter {
	void loadRootFragment(BaseFragment fragment, boolean addToBackStack, boolean isRoot);
}
