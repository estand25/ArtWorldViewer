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
}
