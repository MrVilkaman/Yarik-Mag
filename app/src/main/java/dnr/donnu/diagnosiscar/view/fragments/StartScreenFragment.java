package dnr.donnu.diagnosiscar.view.fragments;


import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.presenter.fragments.StartScreenPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.StartScreenPresenterImpl;

public class StartScreenFragment extends BaseFragment<StartScreenPresenter> implements StartScreenView{

	public static StartScreenFragment open() {
		return new StartScreenFragment();
	}

	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {
		getToolbar().hide();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_start_screen;
	}

	@Override
	protected StartScreenPresenter newPresenter() {
		return new StartScreenPresenterImpl();
	}

	@OnClick(R.id.get_category)
	void onClickCategory(){
		showFragment(CategoryFragment.open());
	}
}
