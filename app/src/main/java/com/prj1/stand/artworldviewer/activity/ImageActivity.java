package com.prj1.stand.artworldviewer.activity;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.androidquery.AQuery;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.activity.adapter.ImagePagerAdapter;

import junit.framework.Assert;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImageActivity extends AppCompatActivity {
	public static final String TAG = "ImageActivity";
	public static final String EXTRA_IMAGE = "image";
	public static final String EXTRA_DESCRIPTION = "name";
	
	private String _imageString;
	private String _imageTitle;
	private ImagePagerAdapter1 _imagePagerAdapter;
	private ArrayList<String> _images;
	
	@BindView(R.id.pager) ViewPager _pager;
	@BindView(R.id.btn_close) ImageButton _closeButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		ButterKnife.bind(this);
		
		_images = (ArrayList<String>) getIntent().getSerializableExtra(EXTRA_IMAGE);
		Log.v("onCreate", _images.get(1));
		Assert.assertNotNull(_images);
		
		_imagePagerAdapter = new ImagePagerAdapter1(this);
		_pager.setAdapter(_imagePagerAdapter);
		_pager.setOffscreenPageLimit(6);
		
		_closeButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
	}
	
	public class ImagePagerAdapter1 extends PagerAdapter {
		private Context _context;
		private LayoutInflater _layoutInflater;
		
		public ImagePagerAdapter1(Context context){
			_context = context;
			_layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}
		
		@Override
		public int getCount() {
			return _images.size();
		}
		
		@Override
		public boolean isViewFromObject(View view, Object object) {
			return  view == object;
		}
		
		@Override
		public Object instantiateItem(ViewGroup container, final int position) {
			View itemView = _layoutInflater.inflate(R.layout.pager_image_item, container, false);
			container.addView(itemView);
			Log.v("instantiateItem","1");
			final SubsamplingScaleImageView subsamplingScaleImageView =
					(SubsamplingScaleImageView) itemView.findViewById(R.id.image);
			
			Glide.with(_context)
					.load(_images.get(position))
					.asBitmap()
					.into(new SimpleTarget<Bitmap>() {
						@Override
						public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
							subsamplingScaleImageView.setImage(ImageSource.bitmap(resource));
						}
					});
			
			return itemView;
		}
		
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}
	}
	
}
