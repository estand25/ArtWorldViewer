package com.prj1.stand.artworldviewer.activity.adapters;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.prj1.stand.artworldviewer.R;

/**
 * ArtworkAdapter that will handle and display the cursor data on the screen
 *
 * Created by Stand on 5/15/2017.
 */
public class ArtworkAdapter extends CursorAdapter{
	
    /**
     * ArtworkAdapter
     * @param context
     * @param cursor
     * @param flag
     */
    public ArtworkAdapter(Context context, Cursor cursor, int flag){
        super(context,cursor,flag);
    }

    /**
     * Class that holds the View elements
     */
    public static class ArtworkViewHolder{
        public final SliderLayout artworkSlideShow;
        public final TextSliderView artworkTextSlider;

        /**
         * ArtworkViewHolder constructor that binds the public layout elements to the
         * ArtworkViewHolder object
         * @param view - The current view for the layout elements
         */
        public ArtworkViewHolder(View view){
            artworkSlideShow = (SliderLayout) view.findViewById(R.id.artworkSlider);
            artworkTextSlider = new TextSliderView(view.getContext());
        }
    }

    /**
     * Inflaters the artwork_item layout and setting the viewHolder to the current view tags
     *
     * @param context - Current context for view
     * @param cursor - Current cursor information
     * @param viewGroup - ViewGroup of the view
     * @return = Inflated view with view holder tags
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        // Inflate the artwork_item (view in the grid)
        View view = LayoutInflater.from(context).inflate(R.layout.artwork_item, viewGroup, false);

        //  Create an instance of artwork view hold and get for the display item
        ArtworkViewHolder artworkViewHolder = new ArtworkViewHolder(view);
        view.setTag(artworkViewHolder);

        // Return the view with all its stuff
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ArtworkViewHolder artworkViewHolder = (ArtworkViewHolder) view.getTag();
	    //Bundle slideNotes = new Bundle();
	    /*artworkViewHolder.artworkTextSlider
			    .description(cursor.getString(2)+" - "+cursor.getString(4))
			    .image(cursor.getString(3))
			    .setScaleType(BaseSliderView.ScaleType.CenterCrop);*/
	    if(cursor.getPosition() <= 2) {
		    artworkViewHolder.artworkTextSlider
				    .description(cursor.getString(1))
				    .image(cursor.getString(2))
				    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
		
		    Log.v("bindView", "cursor 0 " + cursor.getString(0));
		    Log.v("bindView", "cursor 1 " + cursor.getString(1));
		    Log.v("bindView", "cursor 2 " + cursor.getString(2));
	    }
	    else {
		    artworkViewHolder.artworkSlideShow.getCurrentSlider()
				    .description(cursor.getString(1))
				    .image(cursor.getString(2))
				    .setScaleType(BaseSliderView.ScaleType.CenterCrop);
		
		    Log.v("bindView", "cursor 0 " + cursor.getString(0));
		    Log.v("bindView", "cursor 1 " + cursor.getString(1));
		    Log.v("bindView", "cursor 2 " + cursor.getString(2));
	    }
    }
}
