package dnr.donnu.diagnosiscar.model.utils;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PhoneUtils {

	public static void sendSms(Context context, CharSequence phone, String text) {
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + phone));
		intent.putExtra("sms_body", text);
		context.startActivity(intent);
	}
}
