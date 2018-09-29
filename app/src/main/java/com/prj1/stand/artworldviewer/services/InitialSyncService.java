package com.prj1.stand.artworldviewer.services;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;

public class InitialSyncService extends JobService {
    private static final int JOB_ID = 1;
    private static final int ONE_MIN = 60 * 1000;

    private boolean isWorking = false;
    private boolean jobCancelled = false;

    public static void schedule(Context context){
        ComponentName componentName = new ComponentName(context, InitialSyncService.class);
        JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, componentName);

        JobScheduler jobScheduler = (JobScheduler) context.getSystemService(Context.JOB_SCHEDULER_SERVICE);
        jobScheduler.schedule(builder.build());
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        isWorking = true;

        startWorkOnNewThread(params);
        return isWorking;
    }

    private void startWorkOnNewThread(final JobParameters params) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork(params);
            }
        }).start();
    }

    private void doWork(JobParameters params){
        if(jobCancelled)
            return;

        Log.v("InitialSyncService","doWork");
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return isWorking;
    }
}
