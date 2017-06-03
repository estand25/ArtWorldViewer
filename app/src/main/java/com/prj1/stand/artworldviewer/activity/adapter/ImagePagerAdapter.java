package com.prj1.stand.artworldviewer.activity.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.prj1.stand.artworldviewer.R;

/**
 * Single Image Page Adapter for one image clicks
 *
 * Created by Stand on 6/3/2017.
 */

public class ImagePagerAdapter extends PagerAdapter{
	private Context _context;
	private LayoutInflater _layoutInflater;
	
	public ImagePagerAdapter(Context context){
		_context = context;
		_layoutInflater = (LayoutInflater) _context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		return 0;
	}
	
	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((LinearLayout) object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {
		View itemView = _layoutInflater.inflate(R.layout.pager_image_item, container, false);
		container.addView(itemView);
		
		final SubsamplingScaleImageView subsamplingScaleImageView =
				(SubsamplingScaleImageView) itemView.findViewById(R.id.image);
		Glide.with(_context)
				.load(0)
				.asBitmap()
				.into(new SimpleTarget<Bitmap>() {
					@Override
					public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
						subsamplingScaleImageView.setImage(ImageSource.bitmap(resource));
					}
				});
		
		return itemView;
	}
	
	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView((LinearLayout) object);
	}
}
