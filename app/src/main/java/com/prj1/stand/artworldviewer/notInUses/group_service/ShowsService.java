package com.prj1.stand.artworldviewer.notInUses.group_service;


import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.notInUses.shows.Show;
import com.prj1.stand.artworldviewer.notInUses.shows.Shows;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Show information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ShowsService extends IntentService{
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
    public ShowsService() {
        super("ShowsService");
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
    protected void onHandleIntent(Intent showsIntent) {
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getShowsInRangeBySize(0,"25", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Shows>() {
                    @Override
                    public void onResponse(Call<Shows> call, Response<Shows> response) {
                        Log.v("ShowsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ShowsService", "OnResponse - "+call.request());
                        Log.v("ShowsService", "OnResponse - "+response.body().getEmbedded().getShows().size());

                        // Grab the response (a list of Shows) from the API
                        // and puts it in the local list of variable
                        List<Show> Shows = response.body().getEmbedded().getShows();

                        // Content value array that I will pass to bulk insert
                        ContentValues[] bulkShow = new ContentValues[Shows.size()];

                        // Index counter
                        int i = 0;
                        for(Show show: Shows)
                        {
                            // Content that holds all the gene information retrieved
                            // from the API
                            ContentValues showContent = new ContentValues();

                            // Generate unique identify for foreign keys record
                            String link_id = UUID.randomUUID().toString();
                            String image_version_id = UUID.randomUUID().toString();

                            // Set the value of each column and insert the artwork properties
                            showContent.put(DbContract.ShowEntry.COLUMN_SHOW_ID, show.getId());
                            showContent.put(DbContract.ShowEntry.COLUMN_CREATED_AT, show.getCreatedAt());
                            showContent.put(DbContract.ShowEntry.COLUMN_UPDATED_AT, show.getUpdatedAt());
                            showContent.put(DbContract.ShowEntry.COLUMN_NAME, show.getName());
                            showContent.put(DbContract.ShowEntry.COLUMN_DESCRIPTION, (String)show.getDescription());
                            showContent.put(DbContract.ShowEntry.COLUMN_PRESS_RELEASE, (String)show.getPressRelease());
                            showContent.put(DbContract.ShowEntry.COLUMN_START_AT, show.getStartAt());
                            showContent.put(DbContract.ShowEntry.COLUMN_END_AT, show.getEndAt());
                            showContent.put(DbContract.ShowEntry.COLUMN_STATUS, show.getStatus());
                            showContent.put(DbContract.ShowEntry.COLUMN_IMAGE_VERSION_ID, image_version_id);
                            showContent.put(DbContract.ShowEntry.COLUMN_LINK_ID, link_id);

                            // Add Genes details to the contentValue array
                            bulkShow[i] = showContent;

                            // Increment index
                            i++;
                        }

                        // Insert the content array to our local DB
                        contentResolver.bulkInsert(DbContract.ShowEntry.CONTENT_URI,bulkShow);

                    }

                    @Override
                    public void onFailure(Call<Shows> call, Throwable t) {
                        Log.v("ShowsService", "onFailure - Failure on the request");
                        Log.v("ShowsService", "onFailure - "+call.request());

                    }
                });
    }
}
