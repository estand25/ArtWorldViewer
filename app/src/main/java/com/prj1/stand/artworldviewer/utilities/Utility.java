package com.prj1.stand.artworldviewer.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;

import android.util.Log;
import android.view.WindowManager;
import com.prj1.stand.artworldviewer.R;

/**
* Utilities class with utility methods
 *
 * Created by Stand on 6/15/2017.
 */

public class Utility {
	public static String getPreferredGalleryType(Context context){
		// Get the current Shared Preferences for the app
		SharedPreferences sharedPreferences =
				PreferenceManager.getDefaultSharedPreferences(context);
		
		// Populate the type of gallery field with the current gallery options
		return sharedPreferences.getString(
				context.getString(R.string.pref_gallery_option_key),
				context.getString(R.string.pref_gallery_option_default)
		);
	}

	public static ProgressDialog createProgressDialog(Context context) {
		Log.v("Utility","CreateProgressDialog...");
		ProgressDialog dialog = new ProgressDialog(context);
		try {
			dialog.show();
		} catch (WindowManager.BadTokenException e) {

		}
		dialog.setCancelable(false);
		dialog.getWindow()
				.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
		dialog.setContentView(R.layout.progressbar_layout);
		dialog.setMessage("Loading...");
		return dialog;
	}
}
