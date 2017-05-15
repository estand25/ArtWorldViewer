package com.prj1.stand.artworldviewer.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.prj1.stand.artworldviewer.R;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class ArtGalleryActivityFragment extends Fragment {
    //private ArrayList<Artwork> artGallaryList;

    public ArtGalleryActivityFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.v("ArtGActivityFragment", "OnCreate");

        //if(savedInstanceState == null || !savedInstanceState.containsKey("Artwork"))
        //{
        //    artGallaryList = new ArrayList<>(new ArrayList<Artwork>());
        //}
        //else
        //{
        //    artGallaryList = savedInstanceState.getParcelableArrayList("Artwork");
        //}
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_art_gallery, container, false);
    }
}
