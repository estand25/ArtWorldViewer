package com.prj1.stand.artworldviewer.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.prj1.stand.artworldviewer.BuildConfig;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.model.authorization.Token;
import com.prj1.stand.artworldviewer.services.ArtTokenService;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;
import com.prj1.stand.artworldviewer.sync.StartReceiver;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArtGalleryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Send Broadcast to get the Art API Token
        sendBroadcast(new Intent(this, StartReceiver.class));
    }
}
