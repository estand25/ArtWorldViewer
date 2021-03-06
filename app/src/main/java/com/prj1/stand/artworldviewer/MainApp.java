package com.prj1.stand.artworldviewer;

import android.app.Application;
import android.content.Intent;
import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.services.group_services.ArtTokenService;
//import com.prj1.stand.artworldviewer.sync.StartReceiver;
import com.prj1.stand.artworldviewer.utilities.LastSelectionGalleryType;
import com.prj1.stand.artworldviewer.utilities.Utility;

public class MainApp extends Application {
    private String agArtType;
//    StartReceiver starter = new StartReceiver();

    @Override
    public void onCreate() {
        super.onCreate();

        // Set the Contents content for the app
        Constants.cConetext = getApplicationContext();

        // Set the initial Gallery type for the app
        agArtType = Utility.getPreferredGalleryType(this);

        // Check if setting preferences exist yet and if not set it here
        if(agArtType == null) {
            // Get the initial Gallery type for the setting activity
            LastSelectionGalleryType.getInstance().setStringKey("gallery");
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                startService(new Intent(getApplicationContext(), ArtTokenService.class));
            }
        }).start();
    }
}
