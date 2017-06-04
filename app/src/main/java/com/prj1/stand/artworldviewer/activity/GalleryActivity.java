package com.prj1.stand.artworldviewer.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.prj1.stand.artworldviewer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {
	public static final String EXTRA_IMAGE2 = "image";
	public static final String EXTRA_TiTLE2 = "title";
	
	SubsamplingScaleImageView subsamplingScaleImageView;
	TextView titleView;
	ImageButton closeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		closeButton = (ImageButton) findViewById(R.id.btn_close1);
		subsamplingScaleImageView = (SubsamplingScaleImageView) findViewById(R.id.image1);
		titleView = (TextView) findViewById(R.id.art_title);
		
		String image = getIntent().getStringExtra(EXTRA_IMAGE2);
		String title = getIntent().getStringExtra(EXTRA_TiTLE2);
		
		Glide.with(GalleryActivity.this)
				.load(image)
				.asBitmap()
				.into(new SimpleTarget<Bitmap>() {
					@Override
					public void onResourceReady(Bitmap  bitmap, GlideAnimation anim) {
						subsamplingScaleImageView.setImage(ImageSource.bitmap(bitmap));
					}
				});
		
		titleView.setText(title);
		
		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
