package dnr.donnu.diagnosiscar.view.fragments;/**
 * Created by Zahar on 13.12.2015.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;


import butterknife.Bind;
import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.model.utils.PhoneUtils;
import dnr.donnu.diagnosiscar.presenter.fragments.AnswerPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.AnswerPresenterImpl;

public class AnswerFragment extends BaseFragment<AnswerPresenter> implements AnswerView {

	private static final String EXTRA_ANSWER_ID = "answer";

	@Bind(R.id.answer)
	TextView answerView;

	public static AnswerFragment open(int answerId) {
		AnswerFragment answerFragment = new AnswerFragment();
		Bundle args = new Bundle();
		args.putInt(EXTRA_ANSWER_ID,answerId);
		answerFragment.setArguments(args);
		return answerFragment;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_answer;
	}

	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {
		int id = getArguments().getInt(EXTRA_ANSWER_ID);
		getPresenter().loadAnswer(id);
	}

	@Override
	protected AnswerPresenter newPresenter() {
		return new AnswerPresenterImpl();
	}

	@OnClick(R.id.back)
	void onClickCategory(){
		back();
	}

	@OnClick(R.id.sms)
	void onClickGetSmsText(){
		getPresenter().sendSmsText();
	}

	@Override
	public void sendAnswer(String text){
		answerView.setText(text);
	}

	@Override
	public void sendSmsAnswer(String text){
		PhoneUtils.sendSms(getContext(), "", text);
	}
}