package com.prj1.stand.artworldviewer.sync;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import com.prj1.stand.artworldviewer.services.group_services.AllModelService;
import com.prj1.stand.artworldviewer.services.group_services.ArtTokenService;

import java.util.concurrent.TimeUnit;

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
        Log.v("StartReceiver","onReceive - ArtTokenService - Start");
        Intent artToken = new Intent(context, ArtTokenService.class);
        startWakefulService(context,artToken);
        Log.v("StartReceiver","onReceive - ArtTokenService - End");
    }

    public void setAlarm(Context context){

        // Get the Alarm Manager from the context Alarm Service
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);

        // Create an Intent for the PopulateAllMovie class
        Intent intent = new Intent(context, AllModelService.class);

        // Create a PendingIntent for the broadcast and intent
        alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);

        // Wake up the device to fire the alarm ever 30-60 minutes
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                AlarmManager.INTERVAL_HALF_HOUR,
                AlarmManager.INTERVAL_HOUR,
                alarmIntent);
    }
}
