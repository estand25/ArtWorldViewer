package com.prj1.stand.artworldviewer.services.group_services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

import com.prj1.stand.artworldviewer.BuildConfig;
import com.prj1.stand.artworldviewer.utilities.ApiUtility;
import com.prj1.stand.artworldviewer.utilities.TokenUtility;
import com.prj1.stand.artworldviewer.data.DbContract;
import com.prj1.stand.artworldviewer.model.authorization.Token;
import com.prj1.stand.artworldviewer.services.fetching.ApiFetchingService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 /**
 * IntentService that handle retrieving the Token or replaced if expired
 *
 * Created by Stand on 5/7/2017.
 */

public class ArtTokenService extends IntentService{
    // Local Api fetching Service
    private ApiFetchingService apiFetchingService;

    // Define a variable to contain a content resolver instance
    ContentResolver contentResolver;
     
    // Boolean to get new Art information
     private boolean ArtInfo = false;

    /**
      An IntentService must always have a constructor that calls super
     * constructor. The string supplied to the super constructor is used to give
     * a name to the IntentService's background thread
     *
     */
    public ArtTokenService(){
        super("ArtTokenService");
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

    /**
     * Intent handler that populates the TokenUtility token class
     * for future use in query the API
     *
     * @param artTokenIntent
     */
    @Override
    protected void onHandleIntent(final Intent artTokenIntent) {
        // Call the api/retrofit2 passing in the APi client id and client secret to get a access token
        apiFetchingService = ApiUtility.getApiService();
        apiFetchingService.sendAccessRequestToService(BuildConfig.AWV_Client_Id, BuildConfig.AWV_Client_Secret)
                .enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        // Get the current token in the tokens table
                        Cursor cursor = contentResolver.query(DbContract.TokenEntry.CONTENT_URI,
                                null,
                                null,
                                null,
                                null);

                        // Check if cursor has any table data if so read-out the record
                        // otherwise set the new system token and insert the record into the table
                        if(cursor.getCount() > 0) {
                            cursor.moveToPosition(0);

                            Log.d("ArtTokenService", "Token Information: " + cursor.getString(0));
                            Log.d("ArtTokenService", "Token Information: " + cursor.getString(1));
                            Log.d("ArtTokenService", "Token Information: " + cursor.getString(2));
                            Log.d("ArtTokenService", "Token Information: " + cursor.getString(3));

                            try {
                                // Get the system token and compare it to the current dateTime minus 2 days
                                // I will replace the token before it expires+
                                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                                Date currentTokenExpiry = dateFormat.parse(cursor.getString(3));
                                Calendar currentCalDate = Calendar.getInstance();
                                currentCalDate.add(Calendar.DATE,+2);

                                Log.v("ArtTokenService","CurrentCalDate: "+currentCalDate.getTime().toString());
                                Log.v("ArtTokenService","currentTokenExpiry: "+currentTokenExpiry.toString());
                                if(currentCalDate.getTime().compareTo(currentTokenExpiry) > 2)
                                {
                                    Log.v("ArtTokenService","New Token compare to Existing Token");
                                    // Delete the current system token to insert new one
                                    contentResolver.delete(DbContract.TokenEntry.CONTENT_URI, "", new String[]{});

                                    // Set the response token to the system current token
                                    TokenUtility.getInstance().setToken(new Token(response.body().getType(),
                                            response.body().getToken(),
                                            response.body().getExpiresAt(),
                                            response.body().getLinks()));
    
                                    ArtInfo = true;
                                }
                                else
                                {
                                    Log.v("ArtTokenService","Using Existing Token");
                                    // Set the System token to the data token
                                    TokenUtility.getInstance().setToken(new Token(cursor.getString(1),
                                            cursor.getString(2),
                                            cursor.getString(3),
                                            null));
                                }

                            } catch(Exception e){
                                System.out.println(e.getMessage());
                            }
                        }
                        else {
                            Log.v("ArtTokenService","New Token");
                            
                            // Set the response token to the system current token
                            TokenUtility.getInstance().setToken(new Token(response.body().getType(),
                                    response.body().getToken(),
                                    response.body().getExpiresAt(),
                                    response.body().getLinks()));

                            // Create content holder to hold token information
                            ContentValues tokenContentValue = new ContentValues();

                            // Populate content holder with token specific information
                            tokenContentValue.put(DbContract.TokenEntry.COLUMN_TYPE, TokenUtility.getInstance().getOurTokenType());
                            tokenContentValue.put(DbContract.TokenEntry.COLUMN_TOKEN, TokenUtility.getInstance().getOurToken());
                            tokenContentValue.put(DbContract.TokenEntry.COLUMN_EXPIRES_AT, TokenUtility.getInstance().getOurTokenExpire());

                            // Populate the current system token into the token table
                            contentResolver.insert(DbContract.TokenEntry.CONTENT_URI,tokenContentValue);
    
                            ArtInfo = true;
                        }
                        cursor.close();

                        // Only if token is expired will I call this
                        // I will create something else to update the db
                        if(ArtInfo) {
                            Log.v("ArtTokenService", "OnResponse - Got the Token " + TokenUtility.getInstance().getOurToken());
                            Log.v("ArtTokenService", "New Token get ArtInfo ");
                            startService(new Intent(getApplicationContext(), AllModelService.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        Log.v("ArtTokenService", "onFailure - Got nothing, not Token set");
                    }
                });

    }

}
