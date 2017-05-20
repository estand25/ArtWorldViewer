package com.prj1.stand.artworldviewer.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.prj1.stand.artworldviewer.data.DbContract.ArtistEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ArtworkEntry;
import com.prj1.stand.artworldviewer.data.DbContract.FairEntry;
import com.prj1.stand.artworldviewer.data.DbContract.GeneEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ShowEntry;
import com.prj1.stand.artworldviewer.data.DbContract.DimensionEntry;
import com.prj1.stand.artworldviewer.data.DbContract.CMEntry;
import com.prj1.stand.artworldviewer.data.DbContract.INEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ImageEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ImageVersionEntry;
import com.prj1.stand.artworldviewer.data.DbContract.LinkEntry;
import com.prj1.stand.artworldviewer.data.DbContract.PartnerEntry;
import com.prj1.stand.artworldviewer.data.DbContract.PermalinkEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ProfileEntry;
import com.prj1.stand.artworldviewer.data.DbContract.ThumbnailEntry;
import com.prj1.stand.artworldviewer.data.DbContract.WebsiteEntry;
import com.prj1.stand.artworldviewer.data.DbContract.SelfEntry;
import com.prj1.stand.artworldviewer.data.DbContract.PartnerContactEntry;
import com.prj1.stand.artworldviewer.data.DbContract.TokenEntry;

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
        /**
         * Create the string for the individual tables
         */
        final String SQL_CREATE_TOKEN_TABLE = "CREATE TABLE " + TokenEntry.TABLE_NAME + " ( " +
                TokenEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TokenEntry.COLUMN_TYPE + " TEXT NULL, " +
                TokenEntry.COLUMN_TOKEN + " TEXT NULL, " +
                TokenEntry.COLUMN_EXPIRES_AT + " TEXT NOT NULL); ";
        Log.v("Creating - "+TokenEntry.TABLE_NAME,SQL_CREATE_TOKEN_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_TOKEN_TABLE);

        final String SQL_CREATE_ARTIST_TABLE = "CREATE TABLE " + ArtistEntry.TABLE_NAME + " ( " +
                ArtistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ArtistEntry.COLUMN_ARTIST_ID + " TEXT NULL, " +
                ArtistEntry.COLUMN_SLUG + " TEXT NULL, " +
                ArtistEntry.COLUMN_CREATED_AT + " TEXT NULL, " +
                ArtistEntry.COLUMN_UPDATED_AT + " TEXT NULL, " +
                ArtistEntry.COLUMN_NAME + " TEXT NULL, " +
                ArtistEntry.COLUMN_SORTABLE_NAME + " TEXT NULL, " +
                ArtistEntry.COLUMN_GENDER + " TEXT NULL, " +
                ArtistEntry.COLUMN_BIRTHDAY + " TEXT NULL, " +
                ArtistEntry.COLUMN_HOMETOWN + " TEXT NULL, " +
                ArtistEntry.COLUMN_LOCATION + " TEXT NULL, " +
                ArtistEntry.COLUMN_NATIONALITY + " TEXT NULL, " +
                ArtistEntry.COLUMN_LINK_ID + " TEXT NULL, " +

                " UNIQUE (" + ArtistEntry.COLUMN_ARTIST_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + ArtistEntry.COLUMN_LINK_ID + ") REFERENCES " +
                LinkEntry.TABLE_NAME + " (" + LinkEntry.COLUMN_LINK_ID + "));";
        Log.v("Creating - "+ArtistEntry.TABLE_NAME,SQL_CREATE_ARTIST_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ARTIST_TABLE);

        final String SQL_CREATE_ARTWORK_TABLE = "CREATE TABLE " + ArtworkEntry.TABLE_NAME + " ( " +
                ArtworkEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ArtworkEntry.COLUMN_ARTWORK_ID + " TEXT NULL, " +
                ArtworkEntry.COLUMN_SLUG + " TEXT NULL, " +
                ArtworkEntry.COLUMN_CREATED_AT + " TEXT NULL, " +
                ArtworkEntry.COLUMN_UPDATED_AT + " TEXT NULL, " +
                ArtworkEntry.COLUMN_TITLE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_CATEGORY + " TEXT NULL, " +
                ArtworkEntry.COLUMN_MEDIUM + " TEXT NULL, " +
                ArtworkEntry.COLUMN_DATE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_DIMENSIONS_ID + " TEXT NULL, " +
                ArtworkEntry.COLUMN_PUBLISHED + " BLOB NULL, " +
                ArtworkEntry.COLUMN_WEBSITE_ID + " TEXT NULL, " +
                ArtworkEntry.COLUMN_SIGNATURE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_PROVENANCE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_LITERATURE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_EXHIBITION_HISTORY + " TEXT NULL, " +
                ArtworkEntry.COLUMN_COLLECTING_INSTITUTION + " TEXT NULL, " +
                ArtworkEntry.COLUMN_ADDITIONAL_INFORMATION + " TEXT NULL, " +
                ArtworkEntry.COLUMN_IMAGE_RIGHTS + " TEXT NULL, " +
                ArtworkEntry.COLUMN_BLURB + " TEXT NULL, " +
                ArtworkEntry.COLUMN_UNIQUE + " BLOB NULL, " +
                ArtworkEntry.COLUMN_CULTURAL_MAKER + " TEXT NULL, " +
                ArtworkEntry.COLUMN_ICONICITY + " TEXT NULL, " +
                ArtworkEntry.COLUMN_CAN_INQUIRE + " BLOB NULL, " +
                ArtworkEntry.COLUMN_CAN_ACQUIRE + " BLOB NULL, " +
                ArtworkEntry.COLUMN_CAN_SHARE + " BLOB NULL, " +
                ArtworkEntry.COLUMN_SALE_MESSAGE + " TEXT NULL, " +
                ArtworkEntry.COLUMN_SOLD + " BLOB NULL, " +
                ArtworkEntry.COLUMN_IMAGE_VERSION_ID + " TEXT NULL, " +
                ArtworkEntry.COLUMN_LINK_ID + " TEXT NULL, " +

                " UNIQUE (" + ArtworkEntry.COLUMN_ARTWORK_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + ArtworkEntry.COLUMN_DIMENSIONS_ID + ") REFERENCES " +
                DimensionEntry.TABLE_NAME + " (" + DimensionEntry.COLUMN_DIMENSION_ID + ") " +
                " FOREIGN KEY (" + ArtworkEntry.COLUMN_WEBSITE_ID + ") REFERENCES " +
                WebsiteEntry.TABLE_NAME + " (" + WebsiteEntry.COLUMN_WEBSITE_ID + ") " +
                " FOREIGN KEY (" + ArtworkEntry.COLUMN_IMAGE_VERSION_ID + ") REFERENCES " +
                ImageVersionEntry.TABLE_NAME + " (" + ImageVersionEntry.COLUMN_IMAGE_VERSION_ID + ") " +
                " FOREIGN KEY (" + ArtworkEntry.COLUMN_LINK_ID + ") REFERENCES " +
                LinkEntry.TABLE_NAME + " (" + LinkEntry.COLUMN_LINK_ID + ")); ";
        Log.v("Creating - "+ArtworkEntry.TABLE_NAME,SQL_CREATE_ARTWORK_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_ARTWORK_TABLE);

        final String SQL_CREATE_FAIR_TABLE = "CREATE TABLE " + FairEntry.TABLE_NAME + " ( " +
                FairEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                FairEntry.COLUMN_FAIR_ID + " TEXT NULL, " +
                FairEntry.COLUMN_CREATED_AT + " TEXT NULL, " +
                FairEntry.COLUMN_UPDATED_AT + " TEXT NULL, " +
                FairEntry.COLUMN_NAME + " TEXT NULL, " +
                FairEntry.COLUMN_ABOUT + " TEXT NULL, " +
                FairEntry.COLUMN_CONTACT + " TEXT NULL, " +
                FairEntry.COLUMN_SUMMARY + " TEXT NULL, " +
                FairEntry.COLUMN_START_AT + " TEXT NULL, " +
                FairEntry.COLUMN_END_AT + " TEXT NULL, " +
                FairEntry.COLUMN_STATUS + " TEXT NULL, " +
                FairEntry.COLUMN_PUBLISHED + " BLOB NULL, " +
                FairEntry.COLUMN_LINK_ID + " TEXT NULL, " +

                " UNIQUE (" + FairEntry.COLUMN_FAIR_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + FairEntry.COLUMN_LINK_ID + ") REFERENCES " +
                LinkEntry.TABLE_NAME + " (" + LinkEntry.COLUMN_LINK_ID + ")); ";
        Log.v("Creating - "+FairEntry.TABLE_NAME,SQL_CREATE_FAIR_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_FAIR_TABLE);

        final String SQL_CREATE_GENE_TABLE = "CREATE TABLE " + GeneEntry.TABLE_NAME + " ( " +
                GeneEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                GeneEntry.COLUMN_GENE_ID + " TEXT NULL, " +
                GeneEntry.COLUMN_CREATED_AT + " TEXT NULL, " +
                GeneEntry.COLUMN_UPDATED_AT + " TEXT NULL, " +
                GeneEntry.COLUMN_NAME + " TEXT NULL, " +
                GeneEntry.COLUMN_DISPLAY_NAME + " TEXT NULL, " +
                GeneEntry.COLUMN_DESCRIPTION + " TEXT NULL, " +
                GeneEntry.COLUMN_IMAGE_VERSION_ID + " TEXT NULL, " +
                GeneEntry.COLUMN_LINK_ID + " TEXT NULL, " +

                " UNIQUE (" + GeneEntry.COLUMN_GENE_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + GeneEntry.COLUMN_LINK_ID + ") REFERENCES " +
                LinkEntry.TABLE_NAME + " (" + LinkEntry.COLUMN_LINK_ID + ")); ";
        Log.v("Creating - "+GeneEntry.TABLE_NAME,SQL_CREATE_GENE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_GENE_TABLE);

        final String SQL_CREATE_SHOW_TABLE = "CREATE TABLE " + ShowEntry.TABLE_NAME + " ( " +
                ShowEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ShowEntry.COLUMN_SHOW_ID + " TEXT NULL, " +
                ShowEntry.COLUMN_CREATED_AT + " TEXT NULL, " +
                ShowEntry.COLUMN_UPDATED_AT + " TEXT NULL, " +
                ShowEntry.COLUMN_NAME + " TEXT NULL, " +
                ShowEntry.COLUMN_DESCRIPTION + " TEXT NULL, " +
                ShowEntry.COLUMN_PRESS_RELEASE + " TEXT NULL, " +
                ShowEntry.COLUMN_START_AT + " TEXT NULL, " +
                ShowEntry.COLUMN_END_AT + " TEXT NULL, " +
                ShowEntry.COLUMN_STATUS + " TEXT NULL, " +
                ShowEntry.COLUMN_IMAGE_VERSION_ID + " TEXT NULL, " +
                ShowEntry.COLUMN_LINK_ID + " TEXT NULL, " +

                " UNIQUE (" + ShowEntry.COLUMN_SHOW_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + ShowEntry.COLUMN_IMAGE_VERSION_ID + ") REFERENCES " +
                ImageVersionEntry.TABLE_NAME + " (" + ImageVersionEntry.COLUMN_IMAGE_VERSION_ID + ") " +
                " FOREIGN KEY (" + ShowEntry.COLUMN_LINK_ID + ") REFERENCES " +
                LinkEntry.TABLE_NAME + " (" + LinkEntry.COLUMN_LINK_ID + ")); ";
        Log.v("Creating - "+ShowEntry.TABLE_NAME,SQL_CREATE_SHOW_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SHOW_TABLE);

        final String SQL_CREATE_LINK_TABLE = "CREATE TABLE " + LinkEntry.TABLE_NAME + " ( " +
                LinkEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LinkEntry.COLUMN_LINK_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_SELF_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_LINK_TYPE + " TEXT NULL, " +
                LinkEntry.COLUMN_IMAGE_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_THUMBNAIL_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_PERMALINK_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_PARTNER_CONTACT_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_WEBSITE_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_PROFILE_ID + " TEXT NULL, " +
                LinkEntry.COLUMN_PARTNER_ID + " TEXT NULL, " +

                " UNIQUE (" + LinkEntry.COLUMN_LINK_ID + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_SELF_ID + ") REFERENCES " +
                SelfEntry.TABLE_NAME + " (" + SelfEntry.COLUMN_SELF_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_IMAGE_ID + ") REFERENCES " +
                ImageEntry.TABLE_NAME + " (" + ImageEntry.COLUMN_IMAGE_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_THUMBNAIL_ID + ") REFERENCES " +
                ThumbnailEntry.TABLE_NAME + " (" + ThumbnailEntry.COLUMN_THUMBNAIL_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_PERMALINK_ID + ") REFERENCES " +
                PermalinkEntry.TABLE_NAME + " (" + PermalinkEntry.COLUMN_PERMALINK_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_PARTNER_CONTACT_ID + ") REFERENCES " +
                PartnerContactEntry.TABLE_NAME + " (" + PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_WEBSITE_ID + ") REFERENCES " +
                WebsiteEntry.TABLE_NAME + " (" + WebsiteEntry.COLUMN_WEBSITE_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_PARTNER_ID + ") REFERENCES " +
                PartnerEntry.TABLE_NAME + " (" + PartnerEntry.COLUMN_PARTNER_ID + ") " +
                " FOREIGN KEY (" + LinkEntry.COLUMN_PROFILE_ID + ") REFERENCES " +
                ProfileEntry.TABLE_NAME + " (" + ProfileEntry.COLUMN_PROFILE_ID + ")) ";
        Log.v("Creating - "+LinkEntry.TABLE_NAME,SQL_CREATE_LINK_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_LINK_TABLE);

        final String SQL_CREATE_IMAGE_VERSION_TABLE = "CREATE TABLE " + ImageVersionEntry.TABLE_NAME + " ( " +
                ImageVersionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ImageVersionEntry.COLUMN_IMAGE_VERSION_ID + " TEXT NULL, " +
                ImageVersionEntry.COLUMN_VERSION_TYPE + " TEXT NULL );";

        Log.v("Creating - iv",SQL_CREATE_IMAGE_VERSION_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_IMAGE_VERSION_TABLE);

        final String SQL_CREATE_IMAGE_TABLE = "CREATE TABLE " + ImageEntry.TABLE_NAME + " ( " +
                ImageEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ImageEntry.COLUMN_IMAGE_ID + " TEXT NULL, " +
                ImageEntry.COLUMN_TEMPLATED + " TEXT NULL, " +
                ImageEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + ImageEntry.COLUMN_IMAGE_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+ImageEntry.TABLE_NAME,SQL_CREATE_IMAGE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_IMAGE_TABLE);

        final String SQL_CREATE_THUMBNAIL_TABLE = "CREATE TABLE " + ThumbnailEntry.TABLE_NAME + " ( " +
                ThumbnailEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ThumbnailEntry.COLUMN_THUMBNAIL_ID + " TEXT NULL, " +
                ThumbnailEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + ThumbnailEntry.COLUMN_THUMBNAIL_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+ThumbnailEntry.TABLE_NAME,SQL_CREATE_THUMBNAIL_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_THUMBNAIL_TABLE);

        final String SQL_CREATE_PERMALINK_TABLE = "CREATE TABLE " + PermalinkEntry.TABLE_NAME + " ( " +
                PermalinkEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PermalinkEntry.COLUMN_PERMALINK_ID + " TEXT NULL, " +
                PermalinkEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + PermalinkEntry.COLUMN_PERMALINK_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+PermalinkEntry.TABLE_NAME,SQL_CREATE_PERMALINK_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PERMALINK_TABLE);

        final String SQL_CREATE_PROFILE_TABLE = "CREATE TABLE " + ProfileEntry.TABLE_NAME + " ( " +
                ProfileEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ProfileEntry.COLUMN_PROFILE_ID + " TEXT NULL, " +
                ProfileEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + ProfileEntry.COLUMN_PROFILE_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+ProfileEntry.TABLE_NAME,SQL_CREATE_PROFILE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PROFILE_TABLE);

        final String SQL_CREATE_WEBSITE_TABLE = "CREATE TABLE " + WebsiteEntry.TABLE_NAME + " ( " +
                WebsiteEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                WebsiteEntry.COLUMN_WEBSITE_ID + " TEXT NULL, " +
                WebsiteEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + WebsiteEntry.COLUMN_WEBSITE_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+WebsiteEntry.TABLE_NAME,SQL_CREATE_WEBSITE_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_WEBSITE_TABLE);

        final String SQL_CREATE_SELF_TABLE = "CREATE TABLE " + SelfEntry.TABLE_NAME + " ( " +
                SelfEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                SelfEntry.COLUMN_SELF_ID + " TEXT NULL, " +
                SelfEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + SelfEntry.COLUMN_SELF_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+SelfEntry.TABLE_NAME,SQL_CREATE_SELF_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_SELF_TABLE);

        final String SQL_CREATE_PARTNER_CONTACT_TABLE = "CREATE TABLE " + PartnerContactEntry.TABLE_NAME + " ( " +
                PartnerContactEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID + " TEXT NULL, " +
                PartnerContactEntry.COLUMN_HREF + " TEXT NULL, " +

                " UNIQUE (" + PartnerContactEntry.COLUMN_PARTNER_CONTACT_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - pc",SQL_CREATE_PARTNER_CONTACT_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PARTNER_CONTACT_TABLE);

        final String SQL_CREATE_PARTNER_TABLE = "CREATE TABLE " + PartnerEntry.TABLE_NAME + " ( " +
                PartnerEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                PartnerEntry.COLUMN_PARTNER_ID + " TEXT NULL, " +
                PartnerEntry.COLUMN_SLUG + " TEXT NULL, " +
                PartnerEntry.COLUMN_CREATEDAT + " TEXT NULL, " +
                PartnerEntry.COLUMN_UPDATEDAT + " TEXT NULL, " +
                PartnerEntry.COLUMN_TYPE + " TEXT NULL, " +
                PartnerEntry.COLUMN_NAME + " TEXT NULL, " +
                PartnerEntry.COLUMN_EMAIL + " TEXT NULL, " +
                PartnerEntry.COLUMN_REGION + " TEXT NULL, " +

                " UNIQUE (" + PartnerEntry.COLUMN_PARTNER_ID + ") ON CONFLICT REPLACE );";
        Log.v("Creating - "+PartnerEntry.TABLE_NAME,SQL_CREATE_PARTNER_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_PARTNER_TABLE);

        final String SQL_CREATE_DIMENSION_TABLE = "CREATE TABLE " + DimensionEntry.TABLE_NAME + " ( " +
                DimensionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DimensionEntry.COLUMN_DIMENSION_ID + " TEXT NULL, " +
                DimensionEntry.COLUMN_CM_ID + " TEXT NULL, " +
                DimensionEntry.COLUMN_IN_ID + " TEXT NULL, " +

                " UNIQUE (" + DimensionEntry.COLUMN_DIMENSION_ID  + ") ON CONFLICT REPLACE " +
                " FOREIGN KEY (" + DimensionEntry.COLUMN_CM_ID + ") REFERENCES " +
                CMEntry.TABLE_NAME + " (" + CMEntry.COLUMN_CM_ID + ") " +
                " FOREIGN KEY (" + DimensionEntry.COLUMN_IN_ID + ") REFERENCES " +
                INEntry.TABLE_NAME + " (" + INEntry.COLUMN_IN_ID + ")); ";
        Log.v("Creating - "+DimensionEntry.TABLE_NAME,SQL_CREATE_DIMENSION_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_DIMENSION_TABLE);

        final String SQL_CREATE_CM_TABLE = "CREATE TABLE " + CMEntry.TABLE_NAME + " ( " +
                CMEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CMEntry.COLUMN_CM_ID + " TEXT NULL, " +
                CMEntry.COLUMN_TEXT + " TEXT NULL, " +
                CMEntry.COLUMN_HEIGHT + " TEXT NULL, " +
                CMEntry.COLUMN_WIDTH + " TEXT NULL, " +
                CMEntry.COLUMN_DEPTH + " TEXT NULL, " +
                CMEntry.COLUMN_DIAMETER + " TEXT NULL, " +

                " UNIQUE (" + CMEntry.COLUMN_CM_ID + ") ON CONFLICT REPLACE ); ";
        Log.v("Creating - "+CMEntry.TABLE_NAME,SQL_CREATE_CM_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_CM_TABLE);

        final String SQL_CREATE_IN_TABLE = "CREATE TABLE " + INEntry.TABLE_NAME + " ( " +
                INEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                INEntry.COLUMN_IN_ID + " TEXT NULL, " +
                INEntry.COLUMN_TEXT + " TEXT NULL, " +
                INEntry.COLUMN_HEIGHT + " TEXT NULL, " +
                INEntry.COLUMN_WIDTH + " TEXT NULL, " +
                INEntry.COLUMN_DEPTH + " TEXT NULL, " +
                INEntry.COLUMN_DIAMETER + " TEXT NULL, " +

                " UNIQUE (" + INEntry.COLUMN_IN_ID + ") ON CONFLICT REPLACE ); ";
        Log.v("Creating - "+INEntry.TABLE_NAME,SQL_CREATE_IN_TABLE);
        sqLiteDatabase.execSQL(SQL_CREATE_IN_TABLE);
    }

    /**
     * When new database is create old db will be deleted
     * @param sqLiteDatabase - db Object
     * @param i - Old db version
     * @param i1 - new db version
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TokenEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ArtistEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ArtworkEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + FairEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GeneEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ShowEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DimensionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + CMEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + INEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ImageEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ImageVersionEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + LinkEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PartnerEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PermalinkEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ProfileEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + ThumbnailEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + WebsiteEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + SelfEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + PartnerContactEntry.TABLE_NAME);
    }
}
