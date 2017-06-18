package com.prj1.stand.artworldviewer.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.prj1.stand.artworldviewer.R;

public class ImageActivity extends AppCompatActivity {
	public static final String EXTRA_IMAGE = "image";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		// Pass the ArtworkCard to the fragment
		//savedInstanceState.putParcelable(ImageDetailFragment.EXTRA_IMAGE_DETAIL,getIntent().getParcelableExtra(EXTRA_IMAGE));
		
		ImageDetailFragment imageDetailFragment = ((ImageDetailFragment) getSupportFragmentManager()
			.findFragmentById(R.id.fragmentDetail));
	}
}
