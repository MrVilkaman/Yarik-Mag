package dnr.donnu.diagnosiscar.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.model.entity.Question;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenterImpl;

public class QuestionFragment extends BaseFragment<QuestionPresenter> implements QuestionView {

	private static final String EXTRA_QUESTION_ID = "question";
	private static final String EXTRA_CAT_TITLE = "title";

	@Bind(R.id.question)
	TextView question;

	public static QuestionFragment open(Question question, String title) {
		QuestionFragment questionFragment = new QuestionFragment();
		Bundle args = new Bundle();
		args.putInt(EXTRA_QUESTION_ID,question.getId());
		args.putString(EXTRA_CAT_TITLE,title);
		questionFragment.setArguments(args);
		return questionFragment;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_question;
	}


	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {
		Bundle arguments = getArguments();
		getToolbar().setText(arguments.getString(EXTRA_CAT_TITLE));
		int firstId = arguments.getInt(EXTRA_QUESTION_ID, 0);
		getPresenter().initScreen(savedInstanceState, firstId);
	}

	@Override
	protected QuestionPresenter newPresenter() {
		return new QuestionPresenterImpl();
	}

	@Override
	public void showQuestion(String text){
		question.setText(text);
	}

	@Override
	public void showAnswer(int answerId){
		showFragmentWithoutBackStack(AnswerFragment.open(answerId));
	}

	@OnClick(R.id.yes)
	void onClickAnswerYes(){
		getPresenter().clickYes();
	}

	@OnClick(R.id.no)
	void onClickAnswerNo(){
		getPresenter().clickNo();
	}
}