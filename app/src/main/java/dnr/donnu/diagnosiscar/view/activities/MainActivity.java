package dnr.donnu.diagnosiscar.view.activities;

import android.os.Bundle;

import dnr.donnu.diagnosiscar.view.fragments.BaseFragment;
import dnr.donnu.diagnosiscar.view.fragments.CategoryFragment;
import dnr.donnu.diagnosiscar.view.fragments.StartScreenFragment;
import dnr.donnu.diagnosiscar.view.toolbar.Toolbar;


public class MainActivity extends BaseActivity{


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	protected BaseFragment createStartFragment() {
		return StartScreenFragment.open();
	}

	@Override
	protected Toolbar.OnHomeClick getHomeButtonListener() {
		return () -> {};
	}

}
