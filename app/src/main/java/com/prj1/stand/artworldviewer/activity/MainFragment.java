package com.prj1.stand.artworldviewer.activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private GridView mGridView;
    public MainFragment() {}


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // Find the SwipeRefreshLayout and associate to local one
        mSwipeRefreshLayout = (SwipeRefreshLayout)
                rootView.findViewById(R.id.mainFragment_swipe_refresh_layout);

        // Find the GridView on the fragment_main layout and set it to the
        // local representation
        mGridView = (GridView) rootView.findViewById(R.id.mainFragment_gridView);

        Log.v("onCreateView - MF", TokenUtility.getInstance().getOurToken());

        return rootView;
    }
}
