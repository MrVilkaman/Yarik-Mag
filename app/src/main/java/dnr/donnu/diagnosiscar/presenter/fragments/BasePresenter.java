package dnr.donnu.diagnosiscar.presenter.fragments;

import android.content.Context;

import dnr.donnu.diagnosiscar.App;
import dnr.donnu.diagnosiscar.model.DataManager;
import dnr.donnu.diagnosiscar.view.fragments.BaseView;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public abstract class BasePresenter<V extends BaseView> {

	private CompositeSubscription subscriptions;
	private V view;

	public final void setView(V view) {
		if (view == null) {
			subscriptions.unsubscribe();
			onViewBeforeDetached();
			this.view = view;
			onViewDetached();
		} else {
			this.view = view;
			subscriptions = new CompositeSubscription();
			onViewAttached();
		}
	}

	protected void onViewBeforeDetached() {
	}

	protected final <T> void subscribe(Observable<T> observable, Observer<T> observer) {
		subscriptions.add(
				observable
						.subscribeOn(Schedulers.io())
						.observeOn(AndroidSchedulers.mainThread())
						.subscribe(observer)
		);
	}

	protected final <T> void subscribe(Subscription observable) {
		subscriptions.add(observable);
	}

	protected void onViewAttached(){
	}

	protected void onViewDetached() {
	}

	public final V getView() {
		return view;
	}

	public final Context getContext() {
		return view == null ? null : view.getContext();
	}

	protected void showError(Throwable throwable){
		view.showError(throwable);
	}

	public DataManager getDM(){
		return App.get(getContext()).getDM();
	}

}
