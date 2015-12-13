package dnr.donnu.diagnosiscar.presenter.fragments;/**
 * Created by Zahar on 13.12.2015.
 */

import dnr.donnu.diagnosiscar.view.fragments.AnswerView;

public abstract class AnswerPresenter extends BasePresenter<AnswerView> {

	public abstract void sendSmsText();

	public abstract void loadAnswer(int id);
}
