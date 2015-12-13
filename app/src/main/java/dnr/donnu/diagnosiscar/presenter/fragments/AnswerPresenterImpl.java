package dnr.donnu.diagnosiscar.presenter.fragments;


public class AnswerPresenterImpl extends AnswerPresenter {

	@Override
	public void sendSmsText() {
		getView().sendSmsAnswer("qwert");
	}

	@Override
	public void loadAnswer(int id) {
		getView().sendAnswer("id = "+ id);
	}
}
