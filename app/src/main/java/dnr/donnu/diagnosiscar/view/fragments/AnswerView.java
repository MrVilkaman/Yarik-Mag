package dnr.donnu.diagnosiscar.view.fragments;

/**
 * Created by Zahar on 13.12.2015.
 */

public interface AnswerView extends BaseView {

	void sendAnswer(String text);

	void sendSmsAnswer(String text);
}