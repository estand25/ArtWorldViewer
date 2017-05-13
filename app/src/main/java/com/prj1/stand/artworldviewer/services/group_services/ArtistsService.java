package com.prj1.stand.artworldviewer.services.group_services;


import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.Artist;
import com.prj1.stand.artworldviewer.model.Artists;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.concurrent.TimeUnit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * IntentService that handles that retrieve of Artist information from the Art World API
 * extends IntentService
 * Created by Stand on 5/6/2017.
 */

public class ArtistsService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    // Define a variable to contain a content resolver instance
    ContentResolver contentResolver;

    // Protected string for class simple
    protected final String TAG = getClass().getSimpleName();

    /**
     * An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtistsService() {
        super("ArtistsService");
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
    protected void onHandleIntent(Intent artistIntent) {
        // Set the current context content resolver
        contentResolver.delete(DbContract.ArtistEntry.CONTENT_URI, "", new String[]{});

        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtistsInRangeBySize(0,"5", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artists>() {
                    @Override
                    public void onResponse(Call<Artists> call, Response<Artists> response) {
                        Log.v("ArtistsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ArtistsService", "OnResponse - "+call.request());

                        // Grab the response (a list of artist) from the API
                        // and puts it in the local list of variables
                        List<Artist> Artists = response.body().getEmbedded().getArtists();

                        //  Content Value array that I will pass to bulk insert
                        ContentValues[] bulkArtist = new ContentValues[Artists.size()];

                        // Index counter
                        int i = 0;

                        for(Artist artist: Artists){
                            Log.v("ArtistsService","Artist ID: "+artist.getId());
                            Log.v("ArtistsService","Artist Name: "+artist.getName());
                            Log.v("ArtistsService","Artist Gender: "+artist.getGender());
                            Log.v("ArtistsService","Artist Birthday: "+artist.getBirthday());
                            Log.v("ArtistsService","Artist Hometown: "+artist.getHometown());
                            Log.v("ArtistsService","Artist Nationality: "+artist.getNationality());
                            Log.v("ArtistsService","Artist Slug: "+artist.getSlug());
                            Log.v("ArtistsService","Artist Created at: "+artist.getCreatedAt());
                            Log.v("ArtistsService","Artist Updated at: "+artist.getUpdatedAt());
                            Log.v("ArtistsService","Artist Self: "+artist.getLinks().getSelf().getHref());

                            // Content that holds all the artist information
                            // retrieved from the API
                            ContentValues artistContent = new ContentValues();

                            // Set the value of each column and insert the artist properties
                            artistContent.put(DbContract.ArtistEntry.COLUMN_ARTIST_ID, artist.getId());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_NAME, artist.getName());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_GENDER, artist.getGender().toString());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_BIRTHDAY, artist.getBirthday());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_HOMETOWN, artist.getHometown());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_NATIONALITY, artist.getNationality());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_SLUG, artist.getSlug());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_CREATED_AT, artist.getCreatedAt());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_UPDATED_AT, artist.getUpdatedAt());
                            //artistContent.put(DbContract.ArtistEntry.COLUMN_LINK_ID, artist.getLinks().);

                            // Add Artists details to the contentValue array
                            bulkArtist[i] = artistContent;

                            // Increment index
                            i++;
                        }

                        //  Insert the content array to our local DB
                        contentResolver.bulkInsert(DbContract.ArtistEntry.CONTENT_URI,bulkArtist);
                    }

                    @Override
                    public void onFailure(Call<Artists> call, Throwable t) {
                        Log.v("ArtistsService", "onFailure - Failure on the request");
                        Log.v("ArtistsService", "onFailure - "+call.request());
                    }
                });
    }
}
