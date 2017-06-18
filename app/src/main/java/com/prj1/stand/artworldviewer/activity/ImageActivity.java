package com.prj1.stand.artworldviewer.activity;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;


public class ImageActivity extends AppCompatActivity {
	public static final String EXTRA_IMAGE = "image";
	
	
	SubsamplingScaleImageView subsamplingScaleImageView;
	TextView titleView;
	TextView collectionInstitutionView;
	TextView additionalInformationView;
	//TextView websiteView;
	ImageButton closeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		closeButton = (ImageButton) findViewById(R.id.btnImage_close);
		subsamplingScaleImageView = (SubsamplingScaleImageView) findViewById(R.id.image);
		titleView = (TextView) findViewById(R.id.image_title);
		collectionInstitutionView = (TextView) findViewById(R.id.image_collection_Institution);
		additionalInformationView = (TextView) findViewById(R.id.image_additional_information);
		//websiteView = (TextView) findViewById(R.id.image_website);
		
		ArtworkCard artworkCard = getIntent().getParcelableExtra(EXTRA_IMAGE);
		
		Glide.with(ImageActivity.this)
				.load(artworkCard.getAc_thumbnail())
				.asBitmap()
				.into(new SimpleTarget<Bitmap>() {
					@Override
					public void onResourceReady(Bitmap  bitmap, GlideAnimation anim) {
						subsamplingScaleImageView.setImage(ImageSource.bitmap(bitmap));
						//subsamplingScaleImageView.setS;
					}
				});
		
		titleView.setText("Title: "+artworkCard.getAc_title());
		collectionInstitutionView.setText("Collection Institution: "+artworkCard.getAc_collective_institution());
		additionalInformationView.setText("Additional Information: "+artworkCard.getAc_additional_information());
		//websiteView.setText("Website"+artworkCard.getAc_website());
		
		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
