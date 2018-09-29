package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.Log;

import com.prj1.stand.artworldviewer.constants.Constants;
import com.prj1.stand.artworldviewer.utilities.ArtPage;
import com.prj1.stand.artworldviewer.utilities.LastSelectedPage;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.utilities.Utility;

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

        int _offset = intent.getIntExtra(Constants._OFFSET_EXTRA_,0);
        String _size = String.valueOf(intent.getIntExtra(Constants._SIZE_EXTRA_, Constants.PAGE_COUNT));

        LastSelectedPage.getInstance().setArtPage(new ArtPage(_offset,_size, TokenUtility.getInstance().getOurToken()));

        getApplicationContext().startService(new Intent(getApplicationContext(), ArtworksService.class).putExtra(Constants.ARTPAGE, LastSelectedPage.getInstance().getArtPage()));

        Log.v("AllModuleService","Ending All Services ...");
    }
}
