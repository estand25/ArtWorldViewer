package com.prj1.stand.artworldviewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.services.group_services.ArtTokenService;
import com.prj1.stand.artworldviewer.sync.StartReceiver;

import java.util.concurrent.TimeUnit;

public class ArtGalleryActivity extends AppCompatActivity {
    private ArtGalleryActivityFragment artGalleryActivityFragment;
    StartReceiver starter = new StartReceiver();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Intent artToken = new Intent(this, ArtTokenService.class);
        startService(artToken);

        //try {
        //    Log.v("ArtGalleryActivity","Sleep for 10 second...");
        //    TimeUnit.SECONDS.sleep(10);
        //} catch (InterruptedException e) {
        //    Log.v("AllModelService","Can't sleep for 10 second because " + e.getMessage());
        //}

        artGalleryActivityFragment = ((ArtGalleryActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment));

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

        // Start the alarm to pull all the movie data
        starter.setAlarm(this);

        Constants.cConetext = getApplicationContext();
    }
}
