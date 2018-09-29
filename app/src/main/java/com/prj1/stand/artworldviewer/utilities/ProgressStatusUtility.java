package com.prj1.stand.artworldviewer.utilities;

public class ProgressStatusUtility {
    private static ProgressStatusUtility ourInstance;
    private static Boolean ourProgressStatus;

    public static ProgressStatusUtility getInstance() {
        if(ourInstance == null)
            ourInstance = new ProgressStatusUtility();

        return ourInstance;
    }

    private ProgressStatusUtility() {}

    public void setProgressStatus(boolean ps) {
        ourProgressStatus = ps;
    }

    public boolean getOurProgressStatus(){
        return ourProgressStatus;
    }
}
