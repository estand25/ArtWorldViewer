package com.prj1.stand.artworldviewer.activity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.activity.adapters.ArtworkAdapter;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.artworks.Artwork;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArtGalleryActivityFragment extends Fragment
        implements LoaderManager.LoaderCallbacks<Cursor> {

    private ArrayList<Artwork> artGallaryList;
    private SliderLayout sliderShow;
    private ArtworkAdapter artworkAdapter;
    private GridView gridView;
    private int gridSelectionPosition = gridView.INVALID_POSITION;
    public SwipeRefreshLayout mSwipeRefreshLayout;

    public ArtGalleryActivityFragment() {
    }

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callback {
        /**
         * DetailMovieFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Uri dateUri);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("ArtGActivityFragment", "OnCreate");

        if(savedInstanceState == null || !savedInstanceState.containsKey("Artworks"))
        {
            artGallaryList = new ArrayList<>(new ArrayList<Artwork>());
        }
        else
        {
            artGallaryList = savedInstanceState.getParcelableArrayList("Artworks");
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("ArtGActivityFragment", "onSaveInstanceState");

        outState.putParcelableArrayList("Artworks", artGallaryList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.v("ArtGActivityFragment", "onCreateView");

        // Initialize the custom artwork adapter with necessary curse adapter information
        artworkAdapter = new ArtworkAdapter(getActivity(), null, 0);

        // Inflate all the items on the fragment_art_gallery
        View rootView = inflater.inflate(R.layout.fragment_art_gallery, container, false);

        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);

        // Find the GridView on the fragment_art_gallery layout and set it to the
        // local representation
        gridView = (GridView) rootView.findViewById(R.id.artFragment_gridView);

        setupAdapter();

		/*
        sliderShow = (SliderLayout) rootView.findViewById(R.id.slider);

        for(int i = 0; i < artGallaryList.size(); i++) {
            TextSliderView textSliderView = new TextSliderView(rootView.getContext());
            textSliderView
                    .image(artGallaryList.get(i).getLinks().getThumbnail().getHref());
                    //.description("Test")
            sliderShow.addSlider(textSliderView);
        }*/

        // If there's instance state, mine it for useful information.
        // The end-goal here is that the user never knows that turning their device sideways
        // does crazy lifecycle related things.  It should feel like some stuff stretched out,
        // or magically appeared to take advantage of room, but data or place in the app was never
        // actually *lost*.
        if (savedInstanceState != null && savedInstanceState.containsKey(Constants.SELECTED_KEY)) {
            // The gradView probably hasn't even been populated yet.  Actually perform the
            // swap out in onLoadFinished.
            gridSelectionPosition = savedInstanceState.getInt(Constants.SELECTED_KEY);
        }

        // Set-up the SwipeRefreshLayout color order
        mSwipeRefreshLayout.setColorSchemeResources(R.color.colorBlack,R.color.colorGray,R.color.colorDarkGray);

        // Set-up the SwipeRefreshLayout pull-down response
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshContent();
            }
        });

        return rootView;
    }

    /**
     * Handles the refresh functionality for the SwipeRefreshLayout
     * I wasn't sure I could do this so I look around for a couple of examples
     * I found this one
     *
     * https://www.bignerdranch.com/blog/implementing-swipe-to-refresh/
     */
    public void refreshContent(){
        // the refresh handler for the swipeRefreshLayout
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Reset the gridView location
                gridSelectionPosition = 0;

                // Sync the content provide data with internal SQL db's
                onItemChanged();

                // re-connect the adapter to the gridview
                setupAdapter();

                // show the progress of the refresh per the color scheme above
                mSwipeRefreshLayout.setRefreshing(false);
            }
        },250); // wait 25 second
    }

    /**
     * Set-up Adapter to GridView and set-up column number based on device rotation
     */
    private void setupAdapter(){
        // Populate the GridView with custom adapter information
        gridView.setAdapter(artworkAdapter);

        // Check if device is landscape or portrait I got this working, but find a good post about it
        // so I add it as a reference just in case it can be used later
        // http://stackoverflow.com/questions/3674933/find-out-if-android-device-is-portrait-or-landscape-for-normal-usage
        if(Configuration.ORIENTATION_LANDSCAPE == getResources().getConfiguration().orientation) {
            gridView.setNumColumns(3);
        }
        else
        {
            gridView.setNumColumns(2);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("ArtGActivityFragment", "onActivityCreated");

        // Initials the loader
        getLoaderManager().initLoader(1, null, this);
    }

    public void onItemChanged(){
        //  Add the adapter to the gridView and setup the columns depending on the screens orientation
        setupAdapter();

        // Restart the loader
        getLoaderManager().restartLoader(1, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Log.v("ArtGActivityFragment", "onCreateLoader");

        return new CursorLoader(
                getActivity(),
		        DbContract.ArtworkEntry.buildArtworkImagesSection(),
		        //DbContract.ArtworkEntry.buildAllArtworkThumbnailSection(),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        Log.v("ArtGActivityFragment", "onLoadFinished");
        artworkAdapter.swapCursor(data);
        artworkAdapter.notifyDataSetChanged();

        if (gridSelectionPosition != GridView.INVALID_POSITION) {
            // If we don't need to restart the loader, and there's a desired position to restore
            // to, do so now.
            gridView.smoothScrollToPosition(gridSelectionPosition);
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        Log.v("ArtGActivityFragment", "onLoaderReset");
        artworkAdapter.swapCursor(null);
    }
}
