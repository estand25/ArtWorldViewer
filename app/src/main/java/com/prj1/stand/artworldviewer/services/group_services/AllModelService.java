package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import java.util.concurrent.TimeUnit;

/**
 * IntentService that handles that retrieve of all service information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */


public class AllModelService extends IntentService{
    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public AllModelService(){
        super("AllModelService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();
    }


    @Override
    protected void onHandleIntent(Intent intent) {
        // Do not want to over use the Art API so I wait 5 second before I start anything
        try {
            Log.v("AllModelService","Sleep for 5 second...");
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Log.v("AllModelService","Can't sleep for 10 second because " + e.getMessage());
        }

        Log.v("AllModuleService","Starting All Services ...");

        startService(new Intent(getApplicationContext(), ArtistsService.class));
        startService(new Intent(getApplicationContext(), ArtworksService.class));
        startService(new Intent(getApplicationContext(), GenesService.class));
        startService(new Intent(getApplicationContext(), ShowsService.class));
        startService(new Intent(getApplicationContext(), FairsService.class));


        Log.v("AllModuleService","Ending All Services ...");
    }
}
