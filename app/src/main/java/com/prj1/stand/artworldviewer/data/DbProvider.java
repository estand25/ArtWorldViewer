package com.prj1.stand.artworldviewer.data;

import android.content.ContentProvider;
import android.content.UriMatcher;

/**
 * ArtWorldViewer handle the SQLite query create (insertion, deletion, and updates)
 *
 * Created by Stand on 5/13/2017.
 */

public class DbProvider extends ContentProvider {
    private static final UriMatcher aUriMatcher = buildUriMatcher();
    private DbHelper aDbHelper;

    static final int
}
