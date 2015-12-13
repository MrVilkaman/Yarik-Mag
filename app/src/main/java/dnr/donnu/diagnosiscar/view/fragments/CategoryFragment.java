package dnr.donnu.diagnosiscar.view.fragments;


import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.presenter.fragments.CategoryPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.CategoryPresenterImpl;
import dnr.donnu.diagnosiscar.presenter.fragments.StartScreenPresenter;

public class CategoryFragment extends BaseFragment<CategoryPresenter> implements CategoryView {

	public static CategoryFragment open() {
		return new CategoryFragment();
	}

	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {
		getToolbar().setText(R.string.layout_category_title);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_category;
	}

	@Override
	protected CategoryPresenter newPresenter() {
		return new CategoryPresenterImpl();
	}

	@OnClick(R.id.back)
	void onClickCategory(){
		back();
	}
}
