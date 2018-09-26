package com.prj1.stand.artworldviewer.activity;

//import android.app.Fragment;
import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.prj1.stand.artworldviewer.R;

public class ImageActivity extends AppCompatActivity {
	public static final String EXTRA_IMAGE = "image";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);

		Bundle extra = new Bundle();
		extra.putParcelable(ImageDetailFragment.EXTRA_IMAGE_DETAIL,getIntent().getParcelableExtra(EXTRA_IMAGE));
		savedInstanceState = extra;

		ImageDetailFragment imageDetailFragment = new ImageDetailFragment();
		imageDetailFragment.setArguments(savedInstanceState);

		FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
		ft.add(R.id.fragmentDetail, imageDetailFragment);
		ft.commit();
	}
}
