package com.prj1.stand.artworldviewer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.prj1.stand.artworldviewer.R;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.sync.StartReceiver;
import com.prj1.stand.artworldviewer.utilities.LastSelectionGalleryType;
import com.prj1.stand.artworldviewer.utilities.Utility;

public class ArtGalleryActivity extends AppCompatActivity {
    private String agArtType;
    StartReceiver starter = new StartReceiver();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the initial Gallery type for the app
        agArtType = Utility.getPreferredGalleryType(this);
        
        // Set the content for the app initial layout
        setContentView(R.layout.activity_art_gallery);
        
        // Gets the xml element and support it
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    
        // Set the local ArtGalleryActivityFragment to thee xml element equalivet
        ArtGalleryActivityFragment artGalleryActivityFragment = ((ArtGalleryActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment));

        // Set the local floatingActionButon to the xml element and add listeners
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

        // Set the Contents content for the app
        Constants.cConetext = getApplicationContext();
        
        // Check if setting preferences exist yet and if not set it here
        if(agArtType != null) {
            // Get the initial Gallery type for the setting activity
            LastSelectionGalleryType.getInstance().setStringKey("gallery");
        }
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
