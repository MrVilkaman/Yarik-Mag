package dnr.donnu.diagnosiscar.presenter.fragments;


import com.jakewharton.rxbinding.view.RxView;

import dnr.donnu.diagnosiscar.model.entity.Answer;
import rx.android.schedulers.AndroidSchedulers;

public class AnswerPresenterImpl extends AnswerPresenter {

	private String smsText;

	@Override
	public void sendSmsText() {
		getView().sendSmsAnswer(smsText);
	}

	@Override
	public void loadAnswer(int id) {
		getDM().getAnswer(id)
				.map(Answer::getText)
				.doOnNext(this::saveText)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(text -> getView().sendAnswer(text));

	}

	private void saveText(String text) {
		smsText = text;
	}
}
