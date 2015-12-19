package dnr.donnu.diagnosiscar.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import dnr.donnu.diagnosiscar.presenter.activities.BaseActivityPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.BasePresenter;
import dnr.donnu.diagnosiscar.view.activities.BaseActivityView;
import dnr.donnu.diagnosiscar.view.toolbar.Toolbar;


public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView,BaseActivityView {

	private String previousFragment;
	private P relationPresenter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(getLayoutId(), container, false);
		if (isWorkCall()) {
			ButterKnife.bind(this, view);
			getPresenter().setView(this);
			onCreateView(view, savedInstanceState);
		}
		return view;
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		getPresenter().onSaveInstanceState(outState);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
//		App.get(getActivity()).refWatcher().watch(this);
	}

	@Override
	public void onDestroyView() {
		ButterKnife.unbind(this);
		getPresenter().setView(null);
		super.onDestroyView();
	}

	@Override
	public void back() {
		getActivityView().back();
	}

	@Override
	public void hideKeyboard() {
		getActivityView().hideKeyboard();
	}

	@Override
	public void showProgress() {
		getActivityView().showProgress();
	}

	@Override
	public void hideProgress() {
		getActivityView().hideProgress();
	}

	@Override
	public void clearProgress() {
		getActivityView().clearProgress();
	}

	private boolean isWorkCall() {
		return true;
	}

	public String getPreviousFragment() {
		return previousFragment;
	}

	public void setPreviousFragment(String previousFragment) {
		this.previousFragment = previousFragment;
	}

	protected abstract void onCreateView(View view, Bundle savedInstanceState);

	protected abstract int getLayoutId();

	protected void showFragment(BaseFragment fragment) {
		getBaseActivity().loadRootFragment(fragment, true, false);
	}

	protected void showRootFragment(BaseFragment fragment) {
		getBaseActivity().loadRootFragment(fragment, false, true);
	}

	protected void showFragmentWithoutBackStack(BaseFragment fragment) {
		getBaseActivity().loadRootFragment(fragment, false, false);
	}

	protected BaseActivityPresenter getBaseActivity() {
		return (BaseActivityPresenter) getActivity();
	}

	protected BaseActivityView getActivityView() {
		return (BaseActivityView) getActivity();
	}

	protected abstract P newPresenter();

	@Override
	public P getPresenter() {
		if (relationPresenter == null) {
			relationPresenter = newPresenter();
		}
		return relationPresenter;
	}

	@Override
	public Toolbar getToolbar() {
		return getActivityView().getToolbar();
	}


	@Override
	public void showError(Throwable throwable) {
		hideProgress();
		Toast.makeText(getContext(),throwable.getMessage(),Toast.LENGTH_LONG).show();
	}

	@Override
	public void showMessage(int testId) {
//		Utils.showAlert(getContext(),testId);
	}
}
