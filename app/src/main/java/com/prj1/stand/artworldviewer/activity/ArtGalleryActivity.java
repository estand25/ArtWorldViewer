package com.prj1.stand.artworldviewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.services.group_services.ArtTokenService;
import com.prj1.stand.artworldviewer.sync.StartReceiver;
import com.prj1.stand.artworldviewer.utilities.ArtPage;
import com.prj1.stand.artworldviewer.utilities.LastSelectedPage;
import com.prj1.stand.artworldviewer.utilities.LastSelectionGalleryType;
import com.prj1.stand.artworldviewer.utilities.Utility;

import java.util.concurrent.TimeUnit;

public class ArtGalleryActivity extends AppCompatActivity {
    private String agArtType;
    StartReceiver starter = new StartReceiver();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        agArtType = Utility.getPreferredGalleryType(this);
        
        setContentView(R.layout.activity_art_gallery);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    
        ArtGalleryActivityFragment artGalleryActivityFragment = ((ArtGalleryActivityFragment) getSupportFragmentManager()
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
        LastSelectionGalleryType.getInstance().setStringKey("gallery");
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_art_gallery,menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
    
        // Get the current Gallery type from the setting page
        String galleryType = Utility.getPreferredGalleryType(this);
        
        // Check if the gallery type exist and if it doesn't equal the gallery
        // type at the start on the app
        if(galleryType != null && !galleryType.equals(agArtType)){
            ArtGalleryActivityFragment artGalleryActivityFragment =
                    (ArtGalleryActivityFragment) getSupportFragmentManager()
                            .findFragmentById(R.id.container);
            
            if(null != artGalleryActivityFragment) {
                artGalleryActivityFragment.onArtworkChanged();
            }
        }
    }
}
