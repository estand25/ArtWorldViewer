package com.prj1.stand.artworldviewer.sync;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;

import com.prj1.stand.artworldviewer.services.ArtTokenService;

/**
 * Handles the wakefulness and start populating art
 * with IntentSerice
 *
 * Created by Standley Eugene on 5/5/2017.
 */

public class StartReceiver extends WakefulBroadcastReceiver{
    // Alarm Manager, which provides access to the system alarm services
    private AlarmManager alarmManager;


    // The pending intent that is triggered when the alarm fires
    private PendingIntent alarmIntent;

    /**
     * onReceive of the Broadcast I trigger the Art Geners IntentService
     * @param context - The current app context
     * @param intent - The current app intent
     */
    @Override
    public void onReceive(Context context, Intent intent) {
        // Go fetch Art API token
        Intent artToken = new Intent(context, ArtTokenService.class);
        startWakefulService(context,artToken);
    }
}
