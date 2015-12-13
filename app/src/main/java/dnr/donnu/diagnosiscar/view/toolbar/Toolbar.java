package dnr.donnu.diagnosiscar.view.toolbar;

import android.view.View;

public interface Toolbar {

	interface OnToolbarListener{
        void onToolbarViewCreated(View view);
    }

    interface OnHomeClick{
        void onClick();
    }

    void hide();
    void setText(int text);
    void setText(String text);
    void addView(int layoutId, OnToolbarListener viewCreated);
    void clear();

    void hideHomeIcon();

    void showHomeIcon();
    void showBackIcon();


}
