package com.prj1.stand.artworldviewer.activity;

import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
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

        outState.putParcelableArrayList("Artworks", artGallaryList);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //try {
        //    Log.v("ArtGalleryActivity","Sleep for 10 second...");
        //    TimeUnit.SECONDS.sleep(10);
        //} catch (InterruptedException e) {
        //    Log.v("AllModelService","Can't sleep for 10 second because " + e.getMessage());
        //}

        // Initialize the custom artwork adapter with necessary curse adapter information
        artworkAdapter = new ArtworkAdapter(getActivity(), null, 0);

        // Inflate all the items on the fragment_art_gallery
        View rootView = inflater.inflate(R.layout.fragment_art_gallery, container, false);

        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout) rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);

        // Find the GridView on the fragment_art_gallery layout and set it to the
        // local representation
        gridView = (GridView) rootView.findViewById(R.id.artFragment_gridView);

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

        /*
        sliderShow = (SliderLayout) rootView.findViewById(R.id.artSlider);

        TextSliderView textSliderView = new TextSliderView(rootView.getContext());
        textSliderView
                .description("Test")
                .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

        sliderShow.addSlider(textSliderView);*/

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initials the loader
        getLoaderManager().initLoader(0, null, this);
    }

    //@Override
    //public void onStart() {
    //    sliderShow.stopAutoCycle();
    //    super.onStart();
    //}

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(
                getActivity(),
                DbContract.ArtworkEntry.buildAllArtworkThumbnailSection(),
                null,
                null,
                null,
                null
        );
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        artworkAdapter.swapCursor(data);
        artworkAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        artworkAdapter.swapCursor(null);
    }
}
