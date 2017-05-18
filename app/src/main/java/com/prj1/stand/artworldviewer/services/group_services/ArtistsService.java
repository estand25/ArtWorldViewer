package com.prj1.stand.artworldviewer.services.group_services;


import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.prj1.stand.artworldviewer.Utilities.ApiUtility;
import com.prj1.stand.artworldviewer.Utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.artists.Artist;
import com.prj1.stand.artworldviewer.model.artists.Artists;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import java.util.List;
import java.util.UUID;

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
        // Get the current Artists table entry
        /*Cursor cursor = contentResolver.query(DbContract.ArtistEntry.CONTENT_URI,
                null,
                null,
                null,
                null);


        if(cursor.getCount() > 0){
            contentResolver.delete(DbContract.ArtistEntry.CONTENT_URI, "", new String[]{});
        }*/

        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.getArtistsInRangeBySize(0,"25", TokenUtility.getInstance().getOurToken())
                .enqueue(new Callback<Artists>() {
                    @Override
                    public void onResponse(Call<Artists> call, Response<Artists> response) {
                        Log.v("ArtistsService", "OnResponse - Success ..."+response.isSuccessful());
                        Log.v("ArtistsService", "OnResponse - "+call.request());
                        Log.v("ArtistsService", "OnResponse - "+response.body().getEmbedded().getArtists().size());

                        // Grab the response (a list of artist) from the API
                        // and puts it in the local list variable and table
                        List<Artist> Artists = response.body().getEmbedded().getArtists();

                        //  Content Value array that I will pass to bulk insert
                        ContentValues[] bulkArtist = new ContentValues[Artists.size()];

                        // Index counter
                        int i = 0;

                        for(Artist artist: Artists){
                            // Content that holds all the artist information
                            // retrieved from the API
                            ContentValues artistContent = new ContentValues();

                            // Generate unique identify for Link id record
                            String link_id = UUID.randomUUID().toString();

                            // Set the value of each column and insert the artist properties
                            artistContent.put(DbContract.ArtistEntry.COLUMN_ARTIST_ID, artist.getId());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_SLUG, artist.getSlug());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_CREATED_AT, artist.getCreatedAt());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_UPDATED_AT, artist.getUpdatedAt());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_NAME, artist.getName());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_SORTABLE_NAME, artist.getSortableName());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_GENDER, artist.getGender());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_BIRTHDAY, artist.getBirthday());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_HOMETOWN, artist.getHometown());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_LOCATION, artist.getLocation());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_NATIONALITY, artist.getNationality());
                            artistContent.put(DbContract.ArtistEntry.COLUMN_LINK_ID, link_id);

                            // Generate unique identify for self id & permalink id record
                            String self_id = UUID.randomUUID().toString();
                            String permalink_id = UUID.randomUUID().toString();

                            // Content that holds all the links information
                            // retrieved from the API
                            ContentValues linkValue = new ContentValues();
                            ContentValues selfValue = new ContentValues();
                            ContentValues permalinkValue = new ContentValues();

                            linkValue.put(DbContract.LinkEntry.COLUMN_LINK_TYPE, "artist");
                            linkValue.put(DbContract.LinkEntry.COLUMN_SELF_ID, self_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_LINK_ID, link_id);
                            linkValue.put(DbContract.LinkEntry.COLUMN_PERMALINK_ID, permalink_id);

                            selfValue.put(DbContract.SelfEntry.COLUMN_SELF_ID, self_id);
                            selfValue.put(DbContract.SelfEntry.COLUMN_HREF, artist.getLinks().getSelf().getHref());

                            permalinkValue.put(DbContract.PermalinkEntry.COLUMN_PERMALINK_ID, permalink_id);
                            permalinkValue.put(DbContract.PermalinkEntry.COLUMN_HREF, artist.getLinks().getPermalink().getHref());

                            contentResolver.insert(DbContract.LinkEntry.CONTENT_URI,linkValue);
                            contentResolver.insert(DbContract.SelfEntry.CONTENT_URI, selfValue);
                            contentResolver.insert(DbContract.PermalinkEntry.CONTENT_URI, permalinkValue);

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


