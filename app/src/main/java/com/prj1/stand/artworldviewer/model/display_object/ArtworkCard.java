package com.prj1.stand.artworldviewer.model.display_object;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Display class used in the recycle view for display
 *
 * Created by Stand on 5/31/2017.
 */

public class ArtworkCard {
	private String ac_description;
	private String ac_image;
	
	public ArtworkCard(String description, String image){
		ac_description = description;
		ac_image = image;
	}
	
	public String getAc_description(){
		return ac_description;
	}
	
	public String getAc_image(){
		return ac_image;
	}
}
