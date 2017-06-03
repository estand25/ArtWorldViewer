package com.prj1.stand.artworldviewer.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.activity.adapter.ImagePagerAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageActivity extends AppCompatActivity {
	public static final String TAG = "ImageActivity";
	public static final String EXTRA_IMAGE = "image";
	public static final String EXTRA_DESCRIPTION = "name";
	
	private String _imageString;
	private String _imageTitle;
	private ImagePagerAdapter _imagePagerAdapter;
	
	@BindView(R.id.pager)
	ViewPager _pager;
	
	@BindView(R.id.btn_close)
	ImageButton _closeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		
		// Connect the xml element to the local fields
		ButterKnife.bind(this);
		
		_imageString = getIntent().getStringExtra(EXTRA_IMAGE);
		_imageTitle = getIntent().getStringExtra(EXTRA_DESCRIPTION);
		
		_imagePagerAdapter = new ImagePagerAdapter(this);
		
		_pager.setAdapter(_imagePagerAdapter);
		
		_closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}
}
