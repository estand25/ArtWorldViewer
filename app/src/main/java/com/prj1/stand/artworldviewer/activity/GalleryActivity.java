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
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.model.display_object.ArtworkCard;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GalleryActivity extends AppCompatActivity {
	public static final String EXTRA_GALLERY = "image";

	TextView titleView;
	ImageButton closeButton;
	SliderLayout sliderLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		closeButton = (ImageButton) findViewById(R.id.btnGallery_close);
		titleView = (TextView) findViewById(R.id.gallery_title);
		sliderLayout = (SliderLayout) findViewById(R.id.gallery_image);
		
		ArtworkCard artworkCard = getIntent().getParcelableExtra(EXTRA_GALLERY);

		boolean end_loop = false;
		int loopCount = 0;

		while(!end_loop)
		{
			if((artworkCard.getAc_imageHref().size()-1) > loopCount) {
				TextSliderView textSliderView = new TextSliderView(GalleryActivity.this);
				textSliderView
						.description(artworkCard.getAc_image_version().get(loopCount))
						.image(artworkCard.getAc_imageHref().get(loopCount))
						.setScaleType(BaseSliderView.ScaleType.CenterInside);
				
				sliderLayout.addSlider(textSliderView);
				
				loopCount = loopCount + 1;
				Log.v("GalleryActivity", "OnCreate "+artworkCard.getAc_imageHref().get(loopCount));
			}else{
				end_loop = true;
			}
		}
		
		Log.v("GalleryActivity", "OnCreate "+artworkCard.getAc_imageHref().get(0));
		
		titleView.setText("Title: "+artworkCard.getAc_title());
		
		closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
