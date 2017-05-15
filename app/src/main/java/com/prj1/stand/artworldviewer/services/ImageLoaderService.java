package com.prj1.stand.artworldviewer.services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;

import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

/**
 * IntentService that handles the retrieval of artwork images from the local db
 *
 * Created by Stand on 5/14/2017.
 */

public class ImageLoaderService extends IntentService {
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    // Define a variable to contain a content resolver instance
    ContentResolver contentResolver;

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ImageLoaderService() {
        super("ImageLoaderService");
    }

    /**
     * On the IntentService create
     */
    @Override
    public void onCreate() {
        super.onCreate();

        // Set the current context content resolver
        contentResolver = getApplicationContext().getContentResolver();
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // Get the current token in the tokens table
        Cursor cursor = contentResolver.query(DbContract.TokenEntry.CONTENT_URI,
                null,
                null,
                null,
                null);

    }
}
