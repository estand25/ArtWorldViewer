package com.prj1.stand.artworldviewer.model.display_object;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.androidquery.AQuery;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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
	
	public Drawable getAc_image(){
		Drawable dimage = null;
		
		try {
		//	InputStream url = (InputStream) new URL(ac_image).getContent();
		//	image = Drawable.createFromStream(url,ac_image);

		
		Bitmap image = drawable_from_url(ac_image);
		//return image;
		dimage = new BitmapDrawable(image);
		} catch(IOException n){
			n.printStackTrace();
		}
		return dimage;
	}
	
	Bitmap drawable_from_url(String url) throws java.net.MalformedURLException, java.io.IOException {
		Bitmap x;
		
		HttpURLConnection connection = (HttpURLConnection)new URL(url) .openConnection();
		//connection.setRequestProperty("User-agent","Mozilla/4.0");
		
		connection.connect();
		InputStream input = connection.getInputStream();
		
		x = BitmapFactory.decodeStream(input);
		return x;
	}
}
