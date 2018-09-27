package com.prj1.stand.artworldviewer.sync;

import android.app.job.JobParameters;
import android.app.job.JobService;

public class InitialSyncService extends JobService {
    private boolean isWorking = false;
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(JobParameters params) {
        isWorking = true;

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


    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return isWorking;
    }
}
