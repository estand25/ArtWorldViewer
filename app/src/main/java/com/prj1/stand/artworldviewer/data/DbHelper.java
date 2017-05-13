package com.prj1.stand.artworldviewer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.prj1.stand.artworldviewer.data.DbContract.ArtistEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ArtworkEntry;
import com.prj1.stand.artworldviewer.data.DbContract.FairEntry;
import com.prj1.stand.artworldviewer.data.DbContract.GeneEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ShowEntry;


/**
 * Art World Viewer class creates the Database and creates
 * the individual tables
 *
 * Created by Stand on 5/9/2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    private static final int DATABASE_VERSION = 1;

    static final String DATABASE_NAME = "artworlddatabase.db";

    /**
     * Construction for DbHelper
     * @param context
     */
    public DbHelper(Context context){
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create the string for the individual tables
        final String SQL_CREATE_ARTIST_TALBE = "CREATE TALBE " + ArtistEntry.TABLE_NAME + " ( "+
                ArtistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+

    }
}
