package com.prj1.stand.artworldviewer.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.prj1.stand.artworldviewer.R;

public class ImageActivity extends AppCompatActivity {
	public static final String EXTRA_IMAGE = "image";
	ImageDetailFragment imageDetailFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		if(savedInstanceState == null)
		{
            ImageDetailFragment imageDetailFragment = (ImageDetailFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.fragmentDetail);
		}
	}
}
