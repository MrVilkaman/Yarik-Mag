package dnr.donnu.diagnosiscar.view.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.model.entity.Question;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenterImpl;

public class QuestionFragment extends BaseFragment<QuestionPresenter> implements QuestionView {

	private static final String EXTRA_QUESTION = "question";

	@Bind(R.id.question)
	TextView question;

	public static QuestionFragment open(Question question) {
		QuestionFragment questionFragment = new QuestionFragment();
		Bundle args = new Bundle();
		args.putSerializable(EXTRA_QUESTION,question);
		questionFragment.setArguments(args);
		return questionFragment;
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_question;
	}

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Serializable questionItem = getArguments().getSerializable(EXTRA_QUESTION);
		getPresenter().setFirstQuestion(questionItem);
	}

	@Override
	protected void onCreateView(View view, Bundle savedInstanceState) {

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