package dnr.donnu.diagnosiscar.view.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.presenter.adapter.CategoryAdapter;
import dnr.donnu.diagnosiscar.presenter.fragments.CategoryPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.CategoryPresenterImpl;

public class CategoryFragment extends BaseFragment<CategoryPresenter> implements CategoryView {

	@Bind(R.id.list)
	RecyclerView recyclerView;

	private CategoryAdapter adapter;

	public static CategoryFragment open() {
		return new CategoryFragment();
	}

	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {
		getToolbar().setText(R.string.layout_category_title);
		init();
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

	protected void init() {
		LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

		recyclerView.setLayoutManager(layoutManager);
		recyclerView.setAdapter(adapter = new CategoryAdapter());

		adapter.setClickListener(user -> getPresenter().clickOnItem(user));
	}

	@Override
	public void openAnswer(int user) {
		showFragmentWithoutBackStack(QuestionFragment.open(user));
	}
}
