package com.prj1.stand.artworldviewer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Art World Viewer class creates the Database and creates
 * the individual tables
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

    }
}
