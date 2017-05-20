package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.fairs.Fair;
import com.prj1.stand.artworldviewer.model.fairs.Fairs;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.UUID;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Fairs information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class FairsService extends IntentService{
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
    public FairsService() {
        super("FairsService");
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
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getFairsInRangeBySize(0,"25", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Fairs>() {
                    @Override
                    public void onResponse(Call<Fairs> call, Response<Fairs> response) {
                        Log.v("FairsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("FairsService", "OnResponse - "+call.request());
                        Log.v("FairsService", "OnResponse - "+response.body().getEmbedded().getFairs().size());

                        // Grab the response (a list of Fairs) from the API
                        // and puts it in the local list of variable
                        List<Fair> Fairs = response.body().getEmbedded().getFairs();

                        //  Content Value array that I will pass to bulk insert
                        ContentValues[] bulkFair = new ContentValues[Fairs.size()];

                        // Index counter
                        int i = 0;

                        for(Fair fair: Fairs){
                            // Content that holds all the artist information
                            // retrieved from the API
                            ContentValues fairContent = new ContentValues();

                            // Generate unique identify for Link id record
                            String link_id = UUID.randomUUID().toString();

                            // Set the value of each column and insert the artist properties
                            fairContent.put(DbContract.FairEntry.COLUMN_FAIR_ID, fair.getId());
                            fairContent.put(DbContract.FairEntry.COLUMN_CREATED_AT, fair.getCreatedAt());
                            fairContent.put(DbContract.FairEntry.COLUMN_UPDATED_AT, fair.getUpdatedAt());
                            fairContent.put(DbContract.FairEntry.COLUMN_NAME, fair.getName());
                            fairContent.put(DbContract.FairEntry.COLUMN_ABOUT, fair.getAbout());
                            fairContent.put(DbContract.FairEntry.COLUMN_CONTACT, fair.getContact());
                            fairContent.put(DbContract.FairEntry.COLUMN_SUMMARY, fair.getSummary());
                            fairContent.put(DbContract.FairEntry.COLUMN_START_AT, fair.getStartAt());
                            fairContent.put(DbContract.FairEntry.COLUMN_END_AT, fair.getEndAt());
                            fairContent.put(DbContract.FairEntry.COLUMN_STATUS, fair.getStatus());
                            fairContent.put(DbContract.FairEntry.COLUMN_PUBLISHED, fair.getPublished());
                            fairContent.put(DbContract.FairEntry.COLUMN_LINK_ID, link_id);

                            // Add Fairs details to the contentValue array
                            bulkFair[i] = fairContent;

                            // Increment index
                            i++;
                        }

                        // Insert the content array to our local DB
                        contentResolver.bulkInsert(DbContract.FairEntry.CONTENT_URI, bulkFair);
                    }

                    @Override
                    public void onFailure(Call<Fairs> call, Throwable t) {
                        Log.v("FairsService", "onFailure - Failure on the request");
                        Log.v("FairsService", "onFailure - "+call.request());
                    }
                });
    }
}
