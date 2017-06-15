package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.utilities.ArtPage;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;

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
        Log.v("AllModuleService","Starting All Services ...");

        getApplicationContext().startService(new Intent(getApplicationContext(), ArtistsService.class));
        getApplicationContext().startService(new Intent(getApplicationContext(), ArtworksService.class)
        .putExtra(Constants.ARTPAGE,new ArtPage(0,"27", TokenUtility.getInstance().getOurToken())));
        getApplicationContext().startService(new Intent(getApplicationContext(), GenesService.class));
        getApplicationContext().startService(new Intent(getApplicationContext(), ShowsService.class));
        getApplicationContext().startService(new Intent(getApplicationContext(), FairsService.class));

        Log.v("AllModuleService","Ending All Services ...");
    }
}
