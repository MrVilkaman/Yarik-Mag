package dnr.donnu.diagnosiscar.presenter.fragments;

import android.os.Bundle;

import dnr.donnu.diagnosiscar.model.entity.Question;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by Zahar on 13.12.2015.
 */
public class QuestionPresenterImpl extends QuestionPresenter {

	private static final String KEY_ID = "id";
	private int lastId;

	@Override
	protected void onViewAttached() {
		super.onViewAttached();
	}

	@Override
	public void clickYes() {
		getDM().getQuestion(lastId)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(question -> {
					int nextYesQuestionId = question.getNextYesQuestionId();
					if (question.isYesAnswer()) {
						getView().showAnswer(nextYesQuestionId);
					}else{
						showQuestion(nextYesQuestionId);
					}
				});
	}

	@Override
	public void clickNo() {
		getDM().getQuestion(lastId)
				.observeOn(AndroidSchedulers.mainThread())
				.subscribe(question -> {
					int nextYesQuestionId = question.getNextNoQuestionId();
					if (question.isNoAnswer()) {
						getView().showAnswer(nextYesQuestionId);
					}else{
						showQuestion(nextYesQuestionId);
					}
				});
	}

	@Override
	public void showQuestion(int questionItemId) {
		getDM().getQuestion(questionItemId)
				.observeOn(AndroidSchedulers.mainThread())
				.doOnNext(this::saveId)
				.subscribe(question -> getView().showQuestion(question.getText()));
	}

	@Override
	public void initScreen(Bundle savedInstanceState, int firstId) {
		if (savedInstanceState != null) {
			lastId = savedInstanceState.getInt(KEY_ID);
		}else{
			lastId = firstId;
		}

		showQuestion(lastId);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putInt(KEY_ID,lastId);
	}

	private void saveId(Question question) {
		lastId = question.getId();
	}
}
