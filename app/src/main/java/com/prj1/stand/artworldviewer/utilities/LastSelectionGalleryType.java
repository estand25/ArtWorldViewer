package com.prj1.stand.artworldviewer.utilities;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.prj1.stand.artworldviewer.constants.Constants;

/**
 * Handles the setting and getting of SharedPreferences for Last Gallery type selected
 *
 * Created by Stand on 6/12/2017.
 */

public class LastSelectionGalleryType {
	private static final String LAST_SESLECTED_GALLERY_TYPE_KEY = "LAST_SESLECTED_GALLERY_TYPE_KEY";
	private static SharedPreferences gSharedPreferences;
	private static LastSelectionGalleryType gInstance;
	private static Editor gEditor;
	
	private LastSelectionGalleryType(){
	}
	
	/**
	 * Get the instance based on the Context
	 * @return - Return the instance for this class
	 */
	public static LastSelectionGalleryType getInstance(){
		if(gInstance == null)
		{
			Context context = Constants.cConetext;
			gInstance = new LastSelectionGalleryType();
			gSharedPreferences = context.getSharedPreferences("myapp", Context.MODE_PRIVATE);
			gEditor = gSharedPreferences.edit();
		}
		return gInstance;
	}
	
	/**
	 * Get the String Key for the Preferences
	 * @return - Return the String preference for this key
	 */
	public String getStringKey(){
		return gSharedPreferences.getString(LAST_SESLECTED_GALLERY_TYPE_KEY,"");
	}
	
	public void setStringKey(String value){
		gEditor.putString(LAST_SESLECTED_GALLERY_TYPE_KEY, value).apply();
	}
}
