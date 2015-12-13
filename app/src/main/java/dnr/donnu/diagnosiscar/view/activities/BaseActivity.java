package dnr.donnu.diagnosiscar.view.activities;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;



import java.util.List;

import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.presenter.activities.BaseActivityPresenter;
import dnr.donnu.diagnosiscar.view.fragments.BaseFragment;
import dnr.donnu.diagnosiscar.view.toolbar.Toolbar;
import dnr.donnu.diagnosiscar.view.toolbar.ToolbarImpl;


public abstract class BaseActivity extends AppCompatActivity implements BaseActivityPresenter,BaseActivityView {


	private BaseFragment nextFragment;

	private boolean backStack;
	private boolean isRoot;
	private boolean forceLoad;
	private boolean doubleBackToExitPressedOnce;

	private Toolbar toolbar;

	private boolean inProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		toolbar = new ToolbarImpl(findViewById(R.id.toolbar), getHomeButtonListener());
		FragmentManager fm = getSupportFragmentManager();
		Fragment contentFragment = fm.findFragmentById(getContainerID());
		if (contentFragment == null) {
			loadRootFragment(createStartFragment(), true, true);
		}
		configureProgressBar();
	}

	protected abstract Toolbar.OnHomeClick getHomeButtonListener();

	protected abstract BaseFragment createStartFragment();

	protected int getContainerID() {
		return R.id.content;
	}

	private void configureProgressBar() {

	}

	@Override
	public void showProgress() {
		hideKeyboard();
		inProgress = true;
	}

	@Override
	public void hideProgress() {
		inProgress = false;
	}

	@Override
	public void clearProgress(){
		inProgress = false;
	}

	@Override
	public void back() {
		onBackPressed();
	}

	@Override
	public void loadRootFragment(BaseFragment fragment, boolean addToBackStack, boolean isRoot) {
		nextFragment = fragment;
		backStack = addToBackStack;
		this.isRoot = isRoot;
		this.forceLoad = forceLoad;
		nextFragment();
	}

	private void exit() {
		if (doubleBackToExitPressedOnce) {
			finish();
			return;
		}

		this.doubleBackToExitPressedOnce = true;
		Toast.makeText(this, "Еще раз", Toast.LENGTH_SHORT).show();

		new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 1000);
	}

	protected boolean hasChild() {
		return 1 < getSupportFragmentManager().getBackStackEntryCount();
	}

	@Override
	public void onBackPressed() {
		if (!inProgress) {
			FragmentManager supportFragmentManager = getSupportFragmentManager();
			BaseFragment current = (BaseFragment) supportFragmentManager.findFragmentById(getContainerID());
			if (current != null && current.getPreviousFragment() != null) {
				supportFragmentManager.popBackStack(current.getPreviousFragment(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
			} else {
				exit();
			}
		}
	}

	@Override
	public void hideKeyboard() {
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		View view = getCurrentFocus();
		if (view != null) {
			view.clearFocus();
			imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
		}
	}

	void nextFragment() {
		if (nextFragment != null) {
			hideKeyboard();

			BaseFragment currentFragment = (BaseFragment) getSupportFragmentManager().findFragmentById(getContainerID());
			boolean hasOldFragment = currentFragment != null;
			boolean isAlreadyLoaded = false;
			if (hasOldFragment) {
				isAlreadyLoaded = currentFragment.getClass().getSimpleName().equals(nextFragment.getClass().getSimpleName());
			}

			if (!(hasOldFragment && isAlreadyLoaded)) {
				if (isRoot) {
					clearBackStack();
					toolbar.showHomeIcon();
				} else {
					toolbar.showBackIcon();
				}
				FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
				boolean b = backStack || isRoot;
				fragmentTransaction.replace(getContainerID(), nextFragment, nextFragment.getClass().getSimpleName());
				if (currentFragment != null && !isRoot) {
					nextFragment.setPreviousFragment(b ? currentFragment.getClass().getSimpleName() : currentFragment.getPreviousFragment());
					fragmentTransaction.addToBackStack(currentFragment.getClass().getSimpleName());
				}else{
					nextFragment.setPreviousFragment(null);
					fragmentTransaction.addToBackStack(null);
				}
				fragmentTransaction.commit();
			}
			nextFragment = null;
		}
	}

	private void clearBackStack() {
		FragmentManager fragmentManager = getSupportFragmentManager();

		if (0 < fragmentManager.getBackStackEntryCount()) {
			int id = fragmentManager.getBackStackEntryAt(0).getId();
			fragmentManager.popBackStackImmediate(id, FragmentManager.POP_BACK_STACK_INCLUSIVE);
		}

		List<Fragment> fragments = fragmentManager.getFragments();
		if (fragments == null) {
			return;
		}
		FragmentTransaction trans = fragmentManager.beginTransaction();
		for (Fragment fragment : fragments) {
			if (fragment != null) {
				trans.remove(fragment);
			}
		}
		trans.commit();
	}

	protected void updateIcon() {
		if (hasChild()) {
			getToolbar().showBackIcon();
		} else {
			getToolbar().showHomeIcon();
		}
	}

	public Toolbar getToolbar() {
		return toolbar;
	}
}
