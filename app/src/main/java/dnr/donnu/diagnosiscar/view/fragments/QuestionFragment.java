package dnr.donnu.diagnosiscar.view.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.OnClick;
import dnr.donnu.diagnosiscar.R;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenter;
import dnr.donnu.diagnosiscar.presenter.fragments.QuestionPresenterImpl;

public class QuestionFragment extends BaseFragment<QuestionPresenter> implements QuestionView {


	@Bind(R.id.question)
	TextView question;

	public static QuestionFragment open(int user) {
		return new QuestionFragment();
	}

	@Override
	protected int getLayoutId() {
		return R.layout.layout_question;
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