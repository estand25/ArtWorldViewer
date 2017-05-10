package com.prj1.stand.artworldviewer.data;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Art World Viewer classes that handles the individual table defines
 * Created by Stand on 5/9/2017.
 */

public class DbContract {

    // The base location where the tables will be location
    public static final String CONTENT_AUTHORITY = "com.prj1.stand.artworldviewer";

    // URI representation of the root table location
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    // Individual tables name
    public static final String PATH_ARTIST = "artist";
    public static final String PATH_ARTWORK = "artwork";
    public static final String PATH_FAIR ="fair";
    public static final String PATH_GENE = "gene";
    public static final String PATH_SHOW = "show";

    /**
     * Class that create the Artist (ArtistEntry) table
     */
    public static final class ArtistEntry implements BaseColumns {
        /**
         * Location for the specific table (used to access table data)
         */
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_ARTIST).build();

        /**
         * The type of data I will be send if retrieved
         */
        public static final String CONTENT_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE +"/"+CONTENT_AUTHORITY+"/"+PATH_ARTIST;

        /**
         * Build the artist
         * @param ArtistId - Artist unique id
         * @return - Returns Uri
         */
        public static Uri buildArtistDetailSection(int ArtistId){
            return BASE_CONTENT_URI.buildUpon().appendPath("artist_detail")
                    .appendPath(Integer.toString(ArtistId)).build();
        }

        // URI for the specific Artist row in the artist table

        /**
         * URI for the specific Artist row in the artist table
         * @param id - Artist identifier
         * @return - Returns Uri
         */
        public static Uri buildArtistUri(long id){
            return ContentUris.withAppendedId(CONTENT_URI,id);
        }

        /**
         * Uri for specific Artist ID int he Artist table
         * @param ArtistId - Artist unique id
         * @return - Returns Uri
         */
        public static Uri buildArtistIDUri(int ArtistId){
            return CONTENT_URI.buildUpon().appendPath(Integer.toString(ArtistId)).build();
        }

        /**
         * Uri to get the movie id
         * @param uri
         * @return
         */
        public static String getArtistID(Uri uri){
            return uri.getPathSegments().get(1);
        }
    }

}
