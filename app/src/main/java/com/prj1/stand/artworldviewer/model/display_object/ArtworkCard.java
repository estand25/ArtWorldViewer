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
	
	//public Drawable getAc_imageDrawable(){
	//	Bitmap b = getBitmapFromURL(ac_image);
		//Drawable d = new BitmapDrawable(context.g, b);
	//}
	//Drawable d = (Drawable)new BitmapDrawable(getBitmapFromURL(ac_image));
	//return d;
	public static Bitmap getBitmapFromURL(String src) {
		try {
			Log.e("src",src);
			URL url = new URL(src);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoInput(true);
			connection.connect();
			InputStream input = connection.getInputStream();
			Bitmap myBitmap = BitmapFactory.decodeStream(input);
			Log.e("Bitmap","returned");
			return myBitmap;
		} catch (IOException e) {
			e.printStackTrace();
			Log.e("Exception",e.getMessage());
			return null;
		}
	}
}
